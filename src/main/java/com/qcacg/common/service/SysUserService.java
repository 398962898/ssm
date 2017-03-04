package com.qcacg.common.service;

import com.qcacg.common.entity.SysUser;

public interface SysUserService {

	/**
	 * 根据username查找SysUser
	 * @param username
	 * @return
	 */
	public SysUser findSysUserByUsername(String username);
	/**
	 * 注册一个用户
	 * @param sysUser
	 * @return
	 */
	public int insertSysUser(SysUser sysUser);
}
