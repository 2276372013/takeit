package com.take.takeDemo.Service;

import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Entity.GoodsPlace;
import com.take.takeDemo.Entity.GoodsType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    List<Goods> findAll(String userId );
    Integer insertGoods(Goods goods);
    List<String> findAllGoodsPlace(String userId );
    List<String> findAllGoodsType(String userId );
    Integer deleteGoods(String[] goodsIdList);
    Integer findGoodsPlace(GoodsPlace goodsPlace);
    Integer findGoodsType(GoodsType goodsType);
    Integer insertGoodsPlace(GoodsPlace goodsPlace);
    Integer insertGoodsType(GoodsType goodsType);
    List<Goods>  selectLikeGoods(Goods goods);
    List<Goods> findGoodsPasstime(String userId);
    List<Goods> findGoodsWilltime(String userId);
    Integer updatePassTime(String goodsid, String update);
}
