package com.example.demo;

import org.apache.ibatis.annotations.CacheNamespace;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableCaching
@CacheNamespace(implementation=(com.example.demo.config.MybatisRedisCache.class))
@MapperScan("com.example.demo.mapper")
@EnableConfigServer
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
