package com.petty.commdity.dao;

import com.petty.commdity.entity.Goods;
import com.petty.commdity.params.GoodsParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {

    List<Goods> getGoodsList();

    List<Goods> getGoodsListByParams(GoodsParam param);

    List<Goods> getGoodsListByIds(List<String> ids);
}
