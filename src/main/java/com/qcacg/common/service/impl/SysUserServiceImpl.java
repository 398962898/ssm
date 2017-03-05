package com.qcacg.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.qcacg.common.dao.SysUserMapper;
import com.qcacg.common.entity.SysUser;
import com.qcacg.common.entity.SysUserExample;
import com.qcacg.common.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserMapper sysUserMapper;

	private static int amount = 10;

	@Override
	public SysUser findSysUserByUsername(String username) {
		SysUserExample example = new SysUserExample();
		example.or().andUsernameEqualTo(username);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public int insertSysUser(SysUser sysUser) {
		sysUser.setPassword((new Md5Hash(sysUser.getPassword(), sysUser.getUsername(), amount)).toString());
		return sysUserMapper.insertSelective(sysUser);
	}

}
