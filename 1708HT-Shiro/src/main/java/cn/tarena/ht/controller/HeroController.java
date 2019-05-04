package cn.tarena.ht.controller;

import java.util.List;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Hero;
import cn.tarena.ht.service.HeroService;

@Controller
public class HeroController {

	@Autowired
	private HeroService heroService;
	
//	http://localhost:8090/abc/tom/18
	@RequestMapping("/abc/{name}/{age}")
	public String Test(@PathVariable String name
			,@PathVariable Integer age){
		
		return "";
	}
	@RequestMapping("/heros.action")
	public String heros(Model model) throws JsonProcessingException{
		
		List<Hero> heros = heroService.findAll();
		
		Hero h = heros.get(2);
		h.setChecked(true);
		
		
		//如何把对象转成json字符串 
		ObjectMapper mapper = new ObjectMapper();
		
		
		//通过mapper对象 把实体对象的数据装到json字符串中
		String jsonString =	mapper.writeValueAsString(heros);
		System.out.println(jsonString);
		
		
		model.addAttribute("heros", jsonString);
		
		return "zTree";
	}
	
	
}
