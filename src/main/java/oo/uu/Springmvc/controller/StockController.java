package oo.uu.Springmvc.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.PurchaseModel;
import oo.uu.Springmvc.Model.StockModel;
import oo.uu.Springmvc.Service.ProductService;
import oo.uu.Springmvc.Service.StockService;

@Controller
public class StockController {

	@Autowired
	StockService stockServ;

	@Autowired
	ProductService prodServ;
	
/*==========================-- ADD-PRODUCT-UNIT --==========================*/	
	@RequestMapping(value = "/addunit", method = RequestMethod.GET)
	public String AddUnitPage(Map<String, Object> map, StockModel stkModel) {
	    List<StockModel> stkList = stockServ.getAllUnit();
	    map.put("stkList", stkList);
	    map.put("page", "AddUnit.jsp");
	    return "UserDashboard";
	}

	@RequestMapping(value = "/addunits", method = RequestMethod.POST)
	public String AddUnitForm(Map<String, Object> m, StockModel stkModel,RedirectAttributes rw) {
	    boolean isAdded = stockServ.isAddUnit(stkModel);
	    System.out.println("ading unittttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
	    if (isAdded) {
	        System.out.println("Unit added successfully.");
	    } else {
	        System.out.println("Unit not added.");
	    }
	   rw.addFlashAttribute("page", "AddUnit.jsp");
	    return "redirect:addunit";
	}

	 
	
/*==========================-- VIEW PRODUCT-UNIT --==========================*/
	@RequestMapping("/viewunitlist")
	public String UnitList(Map<String, Object> map) {
		List<StockModel> stkList = stockServ.getAllUnit();
		map.put("stkList", stkList);
		return "ViewUnitList";
	}
/*===============================-- ALL-STOCK --===============================*/
	@RequestMapping(value = "/allstock")
	public String allStock(Map<String, Object> map, StockModel stkModel) {
		List<StockModel> StockList = stockServ.getAllStock();
		map.put("StockList", StockList);
		map.put("Stock", "ViewAllStock.jsp");
		return "UserDashboard";
	}
/*============================-- VIEW-CURRENT-STOCK --=========================*/

	@RequestMapping(value = "/viewcurrentstock", method = RequestMethod.GET)
	public String getCurrentStockList(Map<String, Object> m) {
		List<StockModel> curStkList = stockServ.getCurrentStock();
		m.put("curStkList", curStkList);
		m.put("Stock", "ViewCurrentStock.jsp");
		return "UserDashboard";
	}
/*===========================-- ADD CONSUME-STOCK --================================*/

	@RequestMapping(value = "/addconsumestocks", method = RequestMethod.GET)
    public String showAddConsumeStocksPage(Map<String, Object> map) {
		
        List<StockModel> prodwisestock = stockServ.getProductWiseStock();
        List<StockModel> stkList = stockServ.getAllUnit();

        map.put("prodwisestock", prodwisestock);
        map.put("stkList", stkList);
        map.put("pwstock", "AddConsumeStock.jsp");

        return "UserDashboard";
    }

    @RequestMapping(value = "/addconsumestock", method = RequestMethod.POST)
    public String addProdInConsumeStocks(@RequestBody String addconsumestockslist, Map<String, Object> map) {

        Type listType = new TypeToken<List<StockModel>>() {}.getType();
        List<StockModel> addConsumeStocksList1 = new Gson().fromJson(addconsumestockslist, listType);

        boolean consumeList=  stockServ.isAddConsumeStock(addConsumeStocksList1);
        if(consumeList) {
        	System.out.println("data add in consume stock");
        }else {
        	System.out.println("data not add in consume stock");
        }
        map.put("pwstock", "AddConsumeStock.jsp");

        return "UserDashboard";
    }
/*===============================-- VIEW-CONSUME-STOCK --==============================*/

	@RequestMapping(value = "/viewconsumestock", method = RequestMethod.GET)
	public String getConsumeStockList(Map<String, Object> m) {
		List<StockModel> consList = stockServ.getAllConsumeStock();
		m.put("consList", consList);
		m.put("Stock", "ViewConsumeStock.jsp");
		return "UserDashboard";
	}
/*===============================-- VIEW-PRODUCT-WISE-STOCK --=========================*/

	@RequestMapping(value = "/viewproductwisestock")
	public String productWiseStock(Map<String, Object> map) {
		List<StockModel> prodwisestock = stockServ.getProductWiseStock();
		map.put("prodwisestock", prodwisestock);
		map.put("pwstock", "ViewProductWiseStock.jsp");
		return "UserDashboard";
	}
/*==============================-- VIEW REMAINING STOCK --============================*/

	@RequestMapping(value = "/viewremainingstock")
	public String viewRemainingStock(Map<String, Object> map) {
		List<StockModel> remainstock = stockServ.getRemainingStock();
		map.put("remainstock", remainstock);
		map.put("remstock", "ViewRemainingStock.jsp");
		return "UserDashboard";
	}
}
