package com.qcacg.hello.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.qcacg.hello.dao.CountryMapper;
import com.qcacg.hello.entity.Country;
import com.qcacg.hello.entity.CountryExample;
import com.qcacg.hello.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Resource
	private CountryMapper countryMapper;
	@Override
	public List<Country> findByCountry(Country country, int page, int rows) {
		CountryExample example = new CountryExample();
		if(country.getCountryname()!=null&&!"".equals(country.getCountryname().trim())){
			example.or().andCountrynameLike("%"+country.getCountryname()+"%");
		}
		PageHelper.startPage(page, rows);
		return countryMapper.selectByExample(example);
	}

}
