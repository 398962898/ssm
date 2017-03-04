package com.qcacg.common.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.qcacg.common.entity.SysRole;
import com.qcacg.common.entity.SysUser;
import com.qcacg.common.service.SysRoleService;
import com.qcacg.common.service.SysUserService;

public class UserRealm extends AuthorizingRealm {

	@Resource
	private SysUserService sysUserServiceImpl;
	@Resource
	private SysRoleService sysRoleServiceImpl;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		String username = (String) getAvailablePrincipal(arg0);
		List<SysRole> sysRoleList = sysRoleServiceImpl.findRoleByUsername(username);
		List<String> roleList = new ArrayList<String>();
		for (SysRole sysRole : sysRoleList) {
			roleList.add(sysRole.getRolename());
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRoles(roleList);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) arg0;
		String username = upToken.getUsername();
		SysUser sysUser = sysUserServiceImpl.findSysUserByUsername(username);
		if(sysUser == null){
			throw new UnknownAccountException("用户不存在！");
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, sysUser.getPassword(), ByteSource.Util.bytes(username), getName());
		
		return simpleAuthenticationInfo;
	}

}
