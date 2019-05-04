package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
public class HomeController {

//	*.action
//	 /
//	home 
	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(){
		return "/home/title";
	}
	
	//转向home的左侧页面
	@RequestMapping("/homeLeft")
	public String homeLeft(){
		return "/home/left";
	}
	
	//转向home的操作页面
	@RequestMapping("/homeMain")
	public String homeMain(){
		return "/home/main";
	}
	
//	sysadminLeft
//	baseinfoLeft
//	cargoLeft
//	localhost:8090/cargo/Left
 
	@RequestMapping("/{model}/Left")
	public String left(@PathVariable String model){
		return "/"+model+"/left";
	}
	
//	sysadminMain
//	baseinfoMain
//	cargoMain
	@RequestMapping("/{model}/Main")
	public String main(@PathVariable String model){
		return "/"+model+"/main";
	}
	
	
}
