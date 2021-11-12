package com.petty.commdity.service.impl;

import com.petty.commdity.params.GoodsParam;
import com.petty.commdity.service.EsSearchService;
import com.petty.general.response.PageInfo;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EsSearchServiceImpl implements EsSearchService {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public List<String> findIdsByKeyword(String keyword) throws IOException {

        //1、创建查询请求，规定查询的索引
        SearchRequest request = new SearchRequest("mail_goods");
        //2、创建条件构造
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //3、构造条件
        builder.query(QueryBuilders.multiMatchQuery("实惠","describe"));

        //4、将构造好的条件放入请求中
        request.source(builder);

        //5、开始执行发送request请求
        SearchResponse searchResponse = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        //6、开始处理返回的数据
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<String> list = new ArrayList<>();
        for (SearchHit hit : hits) {
            String hitString = hit.getSourceAsString();
            System.out.println(hitString);
            list.add(hitString);
        }

        return null;
    }

    @Override
    public List<String> findIdsByLabels(List<String> labels) {
        return null;
    }

    @Override
    public List<String> getGoodsListByParams(GoodsParam param, PageInfo pageInfo) throws IOException {

        //1、创建查询请求，规定查询的索引
        SearchRequest request = new SearchRequest("mail_goods");
        //2、创建条件构造
        Scroll scroll = new Scroll(new TimeValue(10000));

        //3、构造条件
        SearchSourceBuilder builder = buildFilter(param);
        builder.size(param.getPageSize());
        //4、将构造好的条件放入请求中
        request.source(builder);
        request.scroll(scroll);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        long totalSize = response.getHits().getTotalHits().value;
        pageInfo.setTotal(totalSize);
        pageInfo.setPageSize(param.getPageSize());
        pageInfo.setPageNum(Math.min(param.getPageNum() , totalSize /param.getPageSize()));
        if(pageInfo.getPageNum() == 0){
            pageInfo.setPageNum(1);
        }
        String scrollId = response.getScrollId();

        List<String> list = new ArrayList<>();
        for(int i = 1; i <= pageInfo.getPageNum(); i++){
            if(i == pageInfo.getPageNum()){
                for(SearchHit hit : response.getHits().getHits()) {
                    list.add((String)hit.getSourceAsMap().get("id"));
                }
            }
            SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
            scrollRequest.scroll(scroll);
            response = restHighLevelClient.scroll(scrollRequest, RequestOptions.DEFAULT);
        }

        return list;

    }

    SearchSourceBuilder buildFilter(GoodsParam param){
        SearchSourceBuilder builder = new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if(StringUtils.isNotEmpty(param.getKeyword())){
            boolQueryBuilder.filter(QueryBuilders.multiMatchQuery(param.getKeyword(), "describe", "tags", "labels", "brand"));
        }
        if(StringUtils.isNotEmpty(param.getLabels())){
            boolQueryBuilder.filter(QueryBuilders.matchQuery("labels", param.getLabels()));
        }
        if(StringUtils.isNotEmpty(param.getBrands())){
            boolQueryBuilder.filter(QueryBuilders.matchQuery("brand", param.getBrands()));
        }
        if(StringUtils.isNotEmpty(param.getSourceSite())){
            boolQueryBuilder.filter(QueryBuilders.matchQuery("source_site", param.getSourceSite()));
        }
        if(null != param.getMinPrice() && null != param.getMaxPrice()){
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(param.getMinPrice()).lte(param.getMaxPrice()));
        }else if(null != param.getMaxPrice()){
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").lte(param.getMaxPrice()));
        }else if(null != param.getMinPrice()){
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(param.getMinPrice()));
        }

        builder.query(boolQueryBuilder);
        return  builder;
    }
}
