package com.qcacg.hello.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class CacheController {

	@RequestMapping("pageCache")
	public ModelAndView testPageCache() {
		ModelMap model = new ModelMap();
		Date date = new Date();
		model.addAttribute("date", date.toLocaleString());
		System.out.println("我来访问controller了");
		return new ModelAndView("testPageCache", model);
	}
}
