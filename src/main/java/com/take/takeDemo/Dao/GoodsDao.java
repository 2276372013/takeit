package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Entity.GoodsPlace;
import com.take.takeDemo.Entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface GoodsDao {
    List<Goods>  findAll(String userId);
    Integer insertGoods(Goods goods);
    List<String> findAllGoodsPlace(String userId);
    List<String> findAllGoodsType(String userId);
    Integer deleteGoods(String[] goodsIdList);
    Integer findGoodsPlace(GoodsPlace goodsPlace );
    Integer findGoodsType(GoodsType goodsType);
    Integer insertGoodsPlace(GoodsPlace goodsPlace );
    Integer insertGoodsType(GoodsType goodsType);
    List<Goods> selectLikeGoods(@Param("good") Goods good);
    List<Goods> findGoodsWilltime(String userId);
    List<Goods> findGoodsPasstime(String userId);
    Integer updatePassTime(@Param("goodsid") String goodsid,@Param("update") String update);
    Integer updataGoods(Goods goods);
}
