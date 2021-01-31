package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsDao {
    List<Goods>  findAll(String userId );
    Integer insertGoods(Goods goods);
}
