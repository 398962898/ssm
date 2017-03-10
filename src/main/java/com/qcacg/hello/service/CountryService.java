package com.qcacg.hello.service;

import org.springframework.cache.annotation.Cacheable;

import com.github.pagehelper.PageInfo;
import com.qcacg.hello.entity.Country;

public interface CountryService {
	/**
	 * 根据分页查看
	 * @param country
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Cacheable(cacheNames="countryCache")
	public PageInfo<Country> findByCountry(Country country, int pageNum, int pageSize);
}
