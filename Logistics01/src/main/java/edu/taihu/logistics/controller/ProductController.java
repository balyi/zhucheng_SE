package edu.taihu.logistics.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taihu.logistics.pojo.Product;
import edu.taihu.logistics.pojo.User;
import edu.taihu.logistics.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/add_product")
	public String add_product(Product product,Model model) throws IOException {
			productService.addProduct(product);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
			 String date= format.format(new Date());
			 model.addAttribute("date", date);
			return "/home/add_product";
		}
	@RequestMapping("/to_product_list")
	public String userlist(HttpSession session,Model model){
		User user = (User)session.getAttribute("_CURRENT_USER");
		long startTime=System.currentTimeMillis();
		List<Product> products = productService.findAll(user.getUserId());
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		model.addAttribute("products", products);
		return "/info/product_info";
	}
	@RequestMapping("/delete_product")
	public String delete(Model model,@RequestParam(value="productId",required=false)String[] ids){
		if (ids!=null) {
			productService.delete(ids);
 		}
		return "redirect:/to_product_list";
	}
	@RequestMapping("/to_order")
	public String to_order(HttpSession session,Model model,@RequestParam(value="productId",required=false) String[] productIds) {
		if (productIds!=null) {
			session.setAttribute("productIds", productIds);
			List<Product> products=productService.findProductById(productIds);
			model.addAttribute("products", products);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
			String date= format.format(new Date());
			model.addAttribute("date", date);
		}
		return "/home/add_order";
	}
}
