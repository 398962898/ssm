package com.qcacg.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qcacg.common.entity.SysUser;
import com.qcacg.common.service.SysUserService;

@Controller
public class SysUserController {

	@Resource
	private SysUserService sysUserServiceImpl;
	@RequiresAuthentication
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("time", System.currentTimeMillis());
		return "/WEB-INF/views/index.jsp";
	}
	@GetMapping("/login")
	public String loginView(){
		return "/WEB-INF/views/login.jsp";
	}
	@PostMapping("/login")
	public String login(SysUser sysUser,Model model){
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()){
			UsernamePasswordToken upToken = new UsernamePasswordToken(sysUser.getUsername(),sysUser.getPassword());
			upToken.setRememberMe(true);
			try {
				subject.login(upToken);
			} catch (AuthenticationException e) {
				model.addAttribute("message", "登录失败");
				return "redirect:/login";
			}
			return "redirect:/index";
		}
		return "redirect:/login";
	}
	@GetMapping("/register")
	public String registerView(){
		return "/WEB-INF/views/register.jsp";
	}
	@PostMapping("/register")
	public String register(SysUser sysUser){
		sysUserServiceImpl.insertSysUser(sysUser);
		return "redirect:/login";
	}
	@GetMapping("/print")
	@ResponseBody
	public Map<String,Object> print(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		Map<String,Object> map = new HashMap<String,Object>();
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		map.put("principal", principal);
		map.put("cookies", cookies);
		return map;
	}
}
