package edu.taihu.logistics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(){
		return "/index";
	}
	@RequestMapping("/error")
	public String error() {
		return "/error/404";
	}
	@RequestMapping("/to_add_product")
	public String add_order(Model model) {
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		 String date= format.format(new Date());
		 model.addAttribute("date", date);
		return "/home/add_product";
	}
	@RequestMapping("/introduction")
	public String introduction() {
		return "/home/introduction";
	}
	
}
