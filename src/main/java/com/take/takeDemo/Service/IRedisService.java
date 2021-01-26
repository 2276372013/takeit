package com.take.takeDemo.Service;

public interface IRedisService {
    void setRedisString(String key,String value);
    Object getRedisString(String key);

    void redisHash();

    void redisSet();

    void redisList();

    void redisSortedSet();
}
