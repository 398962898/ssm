package com.qcacg.hello.entity;

import java.io.Serializable;

public class Country implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5872007250074767267L;

	/**
    * 主键
    */
    private Integer id;

    /**
    * 名称
    */
    private String countryname;

    /**
    * 代码
    */
    private String countrycode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}