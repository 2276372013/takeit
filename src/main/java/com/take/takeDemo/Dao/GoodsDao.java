package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Goods;
import org.apache.ibatis.annotations.Mapper;
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

    Integer findGoodsPlace(String userId,String placeName);
    Integer findGoodsType(String userId,String typeName);
    Integer insertGoodsPlace(String userId,String placeName);
    Integer insertGoodsType(String userId,String typeName);
//    Integer insertGoodsPlace(String placeId,String userId,String placeName);
//    Integer insertGoodsType(String typeid,String userId,String typeName);
}
