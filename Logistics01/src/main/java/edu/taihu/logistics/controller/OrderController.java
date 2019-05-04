package edu.taihu.logistics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taihu.logistics.pojo.Contract;
import edu.taihu.logistics.pojo.Order;
import edu.taihu.logistics.pojo.Product;
import edu.taihu.logistics.pojo.User;
import edu.taihu.logistics.service.ContractService;
import edu.taihu.logistics.service.OrderService;
import edu.taihu.logistics.service.ProductService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ContractService contractService;
	
	@RequestMapping("/to_order_list")
	public String to_order_list(Model model,String userId) {
		List<Order> orders=orderService.findOrderByUserId(userId);
		model.addAttribute("orders", orders);
		return "/info/order_info";
	}
	@RequestMapping("/add_order")
	public String add_order(Model model,Order order,HttpSession session) {
		String[] productIds =(String [])session.getAttribute("productIds");
		User user = (User)session.getAttribute("_CURRENT_USER");
		orderService.saveProductAndOrder(productIds,order,user.getUserId());
		productService.changeState(productIds,1);
		contractService.saveContract(productIds,order);
		Contract contract=contractService.findContractById(order.getOrderId());
		model.addAttribute("contract", contract);
		return "/download/contract_download";
	}
	
	@RequestMapping("/to_order_manage")
	public String to_orderlist(Model model) {
		List<Order> orders=orderService.findAll();
		model.addAttribute("orders", orders);
		return "/manage/order_manage";
	}
	@RequestMapping("/distribute_trucks")
	public String distribute_trucks(Model model,@RequestParam(value="orderId",required=false)String[] orderIds) {
		List<Order> orders=orderService.findOrderByIds(orderIds);
		for(Order order:orders) {
			orderService.saveTruckAndOrder(order);
		}
		return "redirect:/to_order_manage";
	}
	@RequestMapping("/send_out")
	public String send_out(Model model,@RequestParam(value="orderId",required=false)String[] orderIds) {
		orderService.changeOrderState(orderIds,2);
		return "redirect:/to_order_manage";
	}
	@RequestMapping("/arrive")
	public String arrive(Model model,@RequestParam(value="orderId",required=false)String[] orderIds) {
		List<Order> orders=orderService.findOrderByIds(orderIds);
		for(Order order:orders) {
			orderService.finishOrder(order);
		}
		return "redirect:/to_order_manage";
	}
	
}
