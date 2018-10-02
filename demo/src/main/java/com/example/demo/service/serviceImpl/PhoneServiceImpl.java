package com.example.demo.service.serviceImpl;

import java.util.List;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PhoneMapper;
import com.example.demo.pojo.Phone;
import com.example.demo.service.PhoneService;


@Service
public class PhoneServiceImpl implements PhoneService {
	@Autowired
	private PhoneMapper phoneMapper;
	@Autowired
	private RedisTemplate<String,Phone> redisTemplate;
	
	public List<Phone> findPhone() {
		System.out.println("jinlai");
		List<Phone> phones;
		if(redisTemplate.hasKey("phone")) {
			System.out.println("从redis数据库中查到了数据");
			phones=(List<Phone>)redisTemplate.opsForList().range("phone", 0, 10);
		}else {
			System.out.println("从Mysql数据库中查到了数据并存到redis中");
			phones = phoneMapper.selectAllPhone();
			for (Phone phone : phones) {
				redisTemplate.opsForList().rightPush("phone", phone);
			}
		}
		return phones;
	}
	
}
