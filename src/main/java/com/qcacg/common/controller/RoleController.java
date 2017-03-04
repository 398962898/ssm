package com.qcacg.common.controller;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RoleController {

	@RequiresRoles("root")
	@GetMapping("/root")
	public String rootMessage(Model model){
		model.addAttribute("message", "root");
		model.addAttribute("time", new Date());
		return "/WEB-INF/views/message.jsp";
	}
	@RequiresRoles("admin")
	@GetMapping("/admin")
	public String adminMessage(Model model){
		model.addAttribute("message", "admin");
		model.addAttribute("time", new Date());
		return "/WEB-INF/views/message.jsp";
	}
	@RequiresRoles("customer")
	@GetMapping("/customer")
	public String customerMessage(Model model){
		model.addAttribute("message", "customer");
		model.addAttribute("time", new Date());
		return "/WEB-INF/views/message.jsp";
	}
}
