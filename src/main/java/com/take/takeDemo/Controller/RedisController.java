package com.take.takeDemo.Controller;

import com.take.takeDemo.Service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private IRedisService redisService;

//    报错原因已修改逻辑
//    @RequestMapping("/redisString")
//    public void redisString() {
//        log.info("RedisController：[redisString]");
//        this.redisService.redisString();
//    }

    @RequestMapping("/redisHash")
    public void redisHash() {
        this.redisService.redisHash();
    }

    @RequestMapping("/redisSet")
    public void redisSet() {
        this.redisService.redisSet();
    }

    @RequestMapping("/redisList")
    public void redisList() {
        this.redisService.redisList();
    }

    @RequestMapping("/redisSortedSet")
    public void redisSortedSet() {
        //有序的set，故而省略
    }
}
