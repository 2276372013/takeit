package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Common.Util.MD5.MD5Util;
import com.take.takeDemo.Dao.GoodsDao;
import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private MD5Util md5Util;

    @Override
    public List<Goods> findAll(String userId) {
        return goodsDao.findAll(userId);
    }

    @Override
    public List<String> findAllGoodsPlace(String userId) {
        return goodsDao.findAllGoodsPlace(userId);
    }

    @Override
    public List<String> findAllGoodsType(String userId) {
        return goodsDao.findAllGoodsType(userId);
    }

    @Override
    public Integer insertGoods(Goods goods) {
        //生成物品代码
        goods.setGoodsCode(MD5(goods));
        if(goods.getGoodsPublic().equals(true)){
            goods.setGoodsPublic("1");
        }else{
            goods.setGoodsPublic("0");
        }
        System.out.println(goods.getSaveTimes());
        System.out.println(goods.getPlaceTime());
        return goodsDao.insertGoods(goods);
//        return null;
    }

    public String MD5(Goods goods){
        String jiami = null;
        try {
            jiami = md5Util.md5(goods.getGoodsName(),goods.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jiami;
    }
}
