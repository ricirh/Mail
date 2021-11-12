package com.petty.commdity.service.impl;

import com.github.pagehelper.PageHelper;
import com.petty.commdity.dao.GoodsDao;
import com.petty.commdity.entity.Goods;
import com.petty.commdity.params.GoodsParam;
import com.petty.commdity.service.EsSearchService;
import com.petty.commdity.service.GoodsService;
import com.petty.general.response.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    EsSearchService esSearchService;

    @Override
    public List<Goods> getGoodList() {
        return goodsDao.getGoodsList();
    }

    @Override
    public PageInfo getGoodsListByParams(GoodsParam param) throws IOException {

        PageInfo pageInfo = new PageInfo();

        List<String> ids = esSearchService.getGoodsListByParams(param,pageInfo);

        List<Goods> list = null;
        if(ids.size() > 0){
            list = goodsDao.getGoodsListByIds(ids);
        }
        pageInfo.setData(list);
        return pageInfo;
    }

}
