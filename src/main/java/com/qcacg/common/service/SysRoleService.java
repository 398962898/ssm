package com.qcacg.common.service;

import java.util.List;

import com.qcacg.common.entity.SysRole;

public interface SysRoleService {
	/**
	 * 根据userId获取角色
	 * @param userId
	 * @return
	 */
	public List<SysRole> findRoleByUserId(Integer userId);
	/**
	 * 根据username获取角色
	 * @param username
	 * @return
	 */
	public List<SysRole> findRoleByUsername(String username);
}
