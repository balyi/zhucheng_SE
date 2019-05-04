package edu.taihu.logistics.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.taihu.logistics.pojo.Truck;
import edu.taihu.logistics.pojo.Product;
import edu.taihu.logistics.pojo.Truck;
import edu.taihu.logistics.service.TruckService;

@Controller
public class TruckController {
	@Autowired
	private TruckService truckService;
	
	@RequestMapping("/to_trucklist")
	public String to_trucklist(Model model) {
		List<Truck> trucks=truckService.findAll();
			model.addAttribute("trucks", trucks);
		return "/manage/truck_manage";
	}
	@RequestMapping("/truck_permit")
	public String truck_permit(Model model,@RequestParam(value="truckId",required=false)String[] truckIds) {
		truckService.changeTruckState(truckIds,0);
		return "redirect:/to_trucklist";
	}
	@RequestMapping("/truck_forbit")
	public String truck_forbit(Model model,@RequestParam(value="truckId",required=false)String[] truckIds) {
		truckService.changeTruckState(truckIds,2);
		return "redirect:/to_trucklist";
	}

}
