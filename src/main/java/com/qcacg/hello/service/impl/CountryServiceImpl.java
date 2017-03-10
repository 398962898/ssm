package com.qcacg.hello.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcacg.hello.dao.CountryMapper;
import com.qcacg.hello.entity.Country;
import com.qcacg.hello.entity.CountryExample;
import com.qcacg.hello.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Resource
	private CountryMapper countryMapper;
	
	@Cacheable(cacheNames="countryCache")
	@Override
	public PageInfo<Country> findByCountry(Country country, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Country> list = countryMapper.select(country);
		return new PageInfo<Country>(list);
	}

}
