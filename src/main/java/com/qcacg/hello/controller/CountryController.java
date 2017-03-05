package com.qcacg.hello.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qcacg.hello.entity.Country;
import com.qcacg.hello.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Resource
	private CountryService countryServiceImpl;

	@RequiresAuthentication
	@ResponseBody
	@GetMapping("/list")
	public PageInfo<Country> all(Country country, 
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		return countryServiceImpl.findByCountry(country, pageNum, pageSize);
	}
}
