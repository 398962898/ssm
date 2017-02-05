package com.qcacg.hello.service;

import java.util.List;

import com.qcacg.hello.entity.Country;

public interface CountryService {
	/**
	 * 根据分页查看
	 * @param country
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Country> findByCountry(Country country, int page, int rows);
}
