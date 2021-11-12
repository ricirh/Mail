package com.petty.merchant.service.impl;

import com.petty.general.response.PageInfo;
import com.petty.merchant.entity.Store;
import com.petty.merchant.service.StoreEsSearchService;
import com.petty.merchant.vo.StoreListParam;
import org.apache.dubbo.config.annotation.Service;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class StoreEsSearchServiceImpl implements StoreEsSearchService {


    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public List<Store> findByName(String name) throws IOException {
        //1、创建查询请求，规定查询的索引
        SearchRequest request = new SearchRequest("mail_store");
        //2、创建条件构造
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //3、构造条件
        builder.query(QueryBuilders.multiMatchQuery(name,"name"));

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

        return  null;
    }

    @Override
    public List<Store> findByField(String keyword) {
        return null;
    }

    @Override
    public PageInfo getStoreListByParams(StoreListParam param) throws IOException {


        return null;

    }
}
