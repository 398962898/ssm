package com.qcacg.common.entity;

import java.io.Serializable;

public class SysRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5610396887125248412L;

	private Integer id;

    private String rolename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}