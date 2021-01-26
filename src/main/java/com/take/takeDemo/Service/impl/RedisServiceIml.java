package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Common.Util.Redis.RedisUtil;
import com.take.takeDemo.Service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Slf4j
@Service("redisService")
public class RedisServiceIml implements IRedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisUtil redisUtil;

    public void setRedisString(String key,String value) {
        //添加值
        redisUtil.stringSet(key, value);
    }

    public Object getRedisString(String key) {
        //取值
        Object value = redisUtil.stringGet(key);
        return value;
    }


    public void redisHash() {
        //添加值
        redisUtil.hashSet("BBB", "test1", "原hash值1");
        redisUtil.hashSet("BBB", "test2", "新hash值1");
        redisUtil.hashSet("BBB", "test1", "原hash值2");
        redisUtil.hashSet("BBB", "test2", "新hash值2");
        //取值
        Object value1 = redisUtil.hashGet("BBB", "test1");
        Object value2 = redisUtil.hashGet("BBB", "test2");
        System.out.println(value1);
        System.out.println(value2);
    }

    public void redisSet() {
        //添值
        redisUtil.setSet("CCC", "这是一组Set集合的第一个");
        redisUtil.setSet("CCC", "这是一组Set集合的第二个");
        redisUtil.setSet("CCC", "这是一组Set集合的第三个");
        //取值
        Set vaule = redisUtil.setGet("CCC");
        System.out.println(vaule);
    }

    public void redisList() {
        //添加值
        redisUtil.listSet("DDD", "这是一组List集合的第一个");
        redisUtil.listSet("DDD", "这是一组List集合的第二个");
        redisUtil.listSet("DDD", "这是一组List集合的第三个");
        //取值
        List list = redisUtil.listGet("DDD", 0, -1);
        System.out.println(list);
    }

    public void redisSortedSet() {
        //有序的set，故而省略
    }
}
