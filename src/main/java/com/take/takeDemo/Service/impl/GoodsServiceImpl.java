package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Common.Util.MD5.MD5Util;
import com.take.takeDemo.Dao.GoodsDao;
import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Entity.GoodsPlace;
import com.take.takeDemo.Entity.GoodsType;
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
    public Integer deleteGoods(String[] goodsIdList) {
        return goodsDao.deleteGoods(goodsIdList);
    }

    @Override
    public Integer findGoodsPlace(GoodsPlace goodsPlace ) {
        return goodsDao.findGoodsPlace(goodsPlace);
    }

    @Override
    public Integer findGoodsType(GoodsType goodsType) {
        return goodsDao.findGoodsType(goodsType);
    }

    @Override
    public Integer insertGoodsPlace(GoodsPlace goodsPlace) {
        return goodsDao.insertGoodsPlace(goodsPlace);
    }

    @Override
    public Integer insertGoodsType(GoodsType goodsType) {
        return goodsDao.insertGoodsType(goodsType);
    }

    @Override
    public List<Goods> selectLikeGoods(Goods goods) {
        return goodsDao.selectLikeGoods(goods);
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
        return goodsDao.insertGoods(goods);
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
