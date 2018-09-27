package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PhoneMapper;
import com.example.demo.pojo.Phone;
import com.example.demo.service.PhoneService;


@Service
public class PhoneServiceImpl implements PhoneService {
	@Autowired
	private PhoneMapper phoneMapper;
	
	public List<Phone> findPhone() {
		System.out.println("jinlai");
		List<Phone> phones = phoneMapper.selectAllPhone();
		System.out.println(phones.size());
		return phones;
	}
	
}
