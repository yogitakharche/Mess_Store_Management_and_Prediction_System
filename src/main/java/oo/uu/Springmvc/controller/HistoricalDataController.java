package oo.uu.Springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.HistoricalDataModel;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.StockModel;
import oo.uu.Springmvc.Service.HistoricalDataService;
import oo.uu.Springmvc.Service.ProductService;
import oo.uu.Springmvc.Service.StockService;

@Controller
public class HistoricalDataController {

	@Autowired
	HistoricalDataService histoServ;

	@Autowired
	ProductService prodServ;

	@Autowired
	StockService stockServ;

/*======================- DATE-CONSUME-LIST -==================================*/
	@RequestMapping(value = "/datewiseconsumedata", method = RequestMethod.GET)
	public String dateConsumeList(Map<String, Object> map, HistoricalDataModel histoModel) {
	    List<HistoricalDataModel> dateConsumeList = histoServ.getDayConsumeList();
	    map.put("dateConsumeList", dateConsumeList);
	    
	    map.put("historicalPage", "DateWiseConsumeList.jsp");
	    return "UserDashboard";
	}

	@RequestMapping(value = "/datewiseconsumedatas", method = RequestMethod.POST)
	public String dateConsumeLists(Map<String, Object> map) {  
	    map.put("historicalPage", "DateWiseConsumeList.jsp");
	    return "UserDashboard";
	}

/*======================- MONTH-CONSUME-LIST -==================================*/	
	
	@RequestMapping(value = "/monthwiseconsumedata", method = RequestMethod.GET)
	public String monthConsumeList(Map<String, Object> map, HistoricalDataModel histoModel) {
		
		List<HistoricalDataModel> monthConsumeList = histoServ.getMonthConsumeList();
		map.put("monthConsumeList", monthConsumeList);
		
		map.put("historicalPage", "MonthWiseConsumeList.jsp");
		return "UserDashboard";
	}
	
	@RequestMapping(value = "/monthwiseconsumedatas", method = RequestMethod.POST)
	public String monthConsumeLists(Map<String, String> map, HistoricalDataModel histoModel) {
		map.put("historicalPage", "MonthWiseConsumeList.jsp");
		return "UserDashboard";
	}
	
/*======================- YEAR-CONSUME-LIST -==================================*/	
	
	@RequestMapping(value = "/yearwiseconsumedata", method = RequestMethod.GET)
	public String yearConsumeList(Map<String, Object> map, HistoricalDataModel histoModel) {
		
		List<HistoricalDataModel> yearConsumeList = histoServ.getYearConsumeList();
		map.put("yearConsumeList", yearConsumeList);
		
		map.put("historicalPage", "YearWiseConsumeList.jsp");
		return "UserDashboard";
	}
	
	
	@RequestMapping(value = "/yearwiseconsumedata", method = RequestMethod.POST)
	public String yearConsumeLists(Map<String, String> map, HistoricalDataModel histoModel) {
		map.put("historicalPage", "YearWiseConsumeList.jsp");
		return "UserDashboard";
	}
	
	
	
	
	
	
	
}
