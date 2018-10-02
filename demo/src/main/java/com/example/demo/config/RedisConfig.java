package com.example.demo.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Redis缓存配置类
 * @author xiaoxin
 *
 */
@Configuration
@EnableCaching
@EnableAutoConfiguration
@ConfigurationProperties(prefix="spring.redis")
public class RedisConfig extends CachingConfigurerSupport{
	 private static Log logger = LogFactory.getLog(RedisConfig.class);
    private String host;
    private int port;
    private int timeout;
   
	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	//自定义缓存key生成策略
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            public Object generate(Object target, java.lang.reflect.Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for(Object obj:params){
                    sb.append(obj.toString());
                }
               return sb.toString();
           }
        };
    }
    
 
    @Bean
    public RedisTemplate<?,?> getRedisTemplate(RedisConnectionFactory redisConnectionFactory){
    	RedisTemplate template=new StringRedisTemplate(redisConnectionFactory);
    	Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    	ObjectMapper oMapper=new ObjectMapper();
    	oMapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
    	oMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    	jackson2JsonRedisSerializer.setObjectMapper(oMapper);
    	System.out.println("redis配置完成！");
    	template.setValueSerializer(jackson2JsonRedisSerializer);
    	template.afterPropertiesSet();
		return template;
    }
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
    	logger.info("RedisTemplate begin init");
        StringRedisTemplate template = new StringRedisTemplate(factory);
        setSerializer(template);//设置序列化工具
        template.afterPropertiesSet();
        logger.info("RedisTemplate init success");
        return template;
    }
     private void setSerializer(StringRedisTemplate template){
            @SuppressWarnings({ "rawtypes", "unchecked" })
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            template.setValueSerializer(jackson2JsonRedisSerializer);
     }        	
}