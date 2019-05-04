package com.chateau.controller;

import com.chateau.pojo.Wine;
import com.chateau.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/order")
public class CartController {
	@Autowired
	private WineService wineService;

	@RequestMapping("/cart")
	public String cart(){
		return "/order/cart";
	}

	@RequestMapping("/toadd")
	public String cartAdd(String wineId,String year, String check,Integer buyNum, HttpSession session) {
		//获取购物车对象
		Object cartObj = session.getAttribute("cart");
		Wine wine = wineService.findInfoById(wineId);
		wine.setCheck(check);
		wine.setDate(Integer.parseInt(year));
		Map<Wine, Integer> cart = null;

		if(cartObj == null){ // "首次"购买商品
			cart = new HashMap<Wine, Integer>();
			session.setAttribute("cart", cart);
		} else { // 非首次购买
			cart = (Map<Wine, Integer>)cartObj;
		}
		if(cart.containsKey(wine)){ // 当前商品已经购买过
			cart.put(wine, cart.get(wine)+buyNum);
		} else { // 当前尚未购买过
			cart.put(wine, buyNum);
		}
		return "order/cart";

	}
	
	@RequestMapping("/todelete")
	public String cartDelete(String wineId,String check ,HttpSession session){
		Object cartObj = session.getAttribute("cart");
		if(cartObj==null){
			return "redirect:/home/index";
		}else{
			Map<Wine, Integer> cart = (Map<Wine, Integer>)cartObj;
			Wine wine = new Wine();
			wine.setWineId(wineId);
			wine.setCheck(check);
			cart.remove(wine);
			return "redirect:/order/cart";
		}

	}

	@RequestMapping("/toedit")
	public String cartEdit(String wineId, Integer buyNum,String check,HttpSession session){
		Object cartObj = session.getAttribute("cart");

		if(cartObj==null ){
			return "/home/index";
		}else{
			Map<Wine, Integer> cart = (Map<Wine, Integer>)cartObj;
			Wine wine = new Wine();
			wine.setWineId(wineId);
			wine.setCheck(check);
			cart.put(wine, buyNum);
			return "redirect:/order/cart";
		}

	}

}
