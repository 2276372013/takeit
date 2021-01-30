package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Dao.GoodsDao;
import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }

    @Override
    public Integer insertArtist(Goods goods) {
        return goodsDao.insertArtist(goods);
    }
}
