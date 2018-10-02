package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;
@Component
public class RedisCacheTransfer {
	/*
	 * 静态注入
	 */
    @Autowired
    public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
        MybatisRedisCache.setRedisConnectionFactory(redisConnectionFactory);
    }

}