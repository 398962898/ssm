package com.qcacg.hello.controller;

import java.util.List;

import javax.annotation.Resource;

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

	@ResponseBody
	@GetMapping("/list")
	public PageInfo<Country> all(Country country, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int rows) {
		List<Country> list = countryServiceImpl.findByCountry(country, page, rows);
		PageInfo<Country> pageInfo = new PageInfo<Country>(list);
		return pageInfo;
	}
}
