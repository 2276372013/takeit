package com.take.takeDemo.Service;

import com.take.takeDemo.Entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    List<Goods> findAll(String userId );
    Integer insertGoods(Goods goods);
}
