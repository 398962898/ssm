package com.qcacg.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qcacg.common.dao.SysRoleMapper;
import com.qcacg.common.entity.SysRole;
import com.qcacg.common.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleMapper sysRoleMapper;
	@Override
	public List<SysRole> findRoleByUserId(Integer userId) {
		return sysRoleMapper.findByUserId(userId);
	}
	@Override
	public List<SysRole> findRoleByUsername(String username) {
		return sysRoleMapper.findRoleByUsername(username);
	}

}
