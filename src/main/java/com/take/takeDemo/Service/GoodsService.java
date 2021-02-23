package com.take.takeDemo.Service;

import com.take.takeDemo.Entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    List<Goods> findAll(String userId );
    Integer insertGoods(Goods goods);
    List<String> findAllGoodsPlace(String userId );
    List<String> findAllGoodsType(String userId );
    Integer deleteGoods(String[] goodsIdList);
    Integer findGoodsPlace(String userId,String placeName);
    Integer findGoodsType(String userId,String typeName);
    Integer insertGoodsPlace(String userId,String goodsPlace);
    Integer insertGoodsType(String userId,String goodsType);
}
