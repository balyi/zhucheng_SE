package edu.taihu.logistics.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.taihu.logistics.pojo.Contract;
import edu.taihu.logistics.pojo.Order;
import edu.taihu.logistics.pojo.User;
import edu.taihu.logistics.service.ContractService;

@Controller
public class ContractController {
	
	@Autowired
	private ContractService contractService;
		
	@RequestMapping("/to_contract_list")
	public String to_contract_list(Model model,String userId) {
		List<Contract> contracts=contractService.findContractByUserId(userId);
		model.addAttribute("contracts", contracts);
		return "/info/contract_info";
	}
	
	@RequestMapping("/to_contract")
	public String add_order(HttpSession session,Model model,String orderId) {
		Contract contract=contractService.findContractById(orderId);
		model.addAttribute("contract", contract);
		if(session.getAttribute("contract")!=null) {
			session.removeAttribute("contract");
		}
		session.setAttribute("contract", contract);
		return "/download/contract_download";
	}
}
