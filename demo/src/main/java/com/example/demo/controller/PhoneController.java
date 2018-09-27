package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Phone;
import com.example.demo.service.PhoneService;


@Controller
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping("/show")
	public String showAllPhone(Model model) {
		List<Phone> phones = phoneService.findPhone();
		model.addAttribute("phones", phones);
		return "phone";
	}
}
