package oo.uu.Springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Service.PredictionService;
import oo.uu.Springmvc.Service.ProductService;

@Controller
public class PredictionController {

	@Autowired
	PredictionService predictServ;
	
	@Autowired
	ProductService prodServ;
	
	@RequestMapping("/monthrequired")
	public String monthRequiredStock(Map<String, Object> map) {
		List<ProductModel> prodList = prodServ.getAllProducts();
		map.put("prodList", prodList);
		map.put("UserPage", "MonthRequiredStock.jsp");
		return "UserDashboard";
	}
	
	
	@RequestMapping("/yearrequired")
	public String yearRequiredStock(Map<String, Object> map) {
		List<ProductModel> prodList = prodServ.getAllProducts();
		map.put("prodList", prodList);
		map.put("UserPage", "YearRequiredStock.jsp");
		return "UserDashboard";
	}
	
	
	
}
