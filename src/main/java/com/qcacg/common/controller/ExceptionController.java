package com.qcacg.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

	@GetMapping("/500")
	public String serviceException(Model model){
		model.addAttribute("message", "服务器异常");
		return "/WEB-INF/views/error.jsp";
	}
	
	@GetMapping("/401")
	public String authorizationException(Model model){
		model.addAttribute("message", "用户无权限");
		return "/WEB-INF/views/error.jsp";
	}
}
