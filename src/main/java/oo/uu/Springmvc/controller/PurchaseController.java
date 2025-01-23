package oo.uu.Springmvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.http.HttpServletRequest;
import oo.uu.Springmvc.Model.DataModel;
import oo.uu.Springmvc.Model.InvoiceModel;
import oo.uu.Springmvc.Model.OrderListModel;
import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.PurchaseModel;
import oo.uu.Springmvc.Model.StockModel;
import oo.uu.Springmvc.Model.UserModel;
import oo.uu.Springmvc.Model.VendorModel;
import oo.uu.Springmvc.Service.ProductService;
import oo.uu.Springmvc.Service.PurchaseService;
import oo.uu.Springmvc.Service.StockService;
import oo.uu.Springmvc.Service.VendorService;

@Controller
public class PurchaseController {

	@Autowired
	PurchaseService purchServ;

	@Autowired
	VendorService vendServ;

	@Autowired
	ProductService prodServ;

	@Autowired
	StockService stockServ;

	/*
	 * ======================================PRODUCT-LIST-CONTROLLER================
	 * ==================
	 */
	@RequestMapping(value = "/productlist")
	public ModelAndView getProductList(ModelAndView mv) {
		mv.addObject("purch", "ProductList.jsp");
		List<VendorModel> vlist = vendServ.getAllVendor();
		mv.addObject("vlist", vlist);

		mv.setViewName("UserDashboard");
		return mv;
	}

	@RequestMapping(value = "/productlist", method = RequestMethod.POST)
	public String isProductList(HttpServletRequest request, Map<String, Object> map, PurchaseModel pModel)
			throws IOException {
		boolean b = purchServ.isAddProductList(pModel);
		if (b) {
			map.put("createlist", true);
		} else {
			map.put("createlist",false);
		}
		return "redirect:viewprodlist";
	}

	@RequestMapping(value = "/deleteprodlist")
	public String deleteProductList(@RequestParam("dpid") Integer dpid, Map<String, Object> map) {
		boolean b = purchServ.isDeleteProductList(dpid);

		return "redirect:viewprodlist";
	}

	/*
	 * =============================================================================
	 * ====================
	 */

	@RequestMapping(value = "/viewprodlist", method = RequestMethod.GET)
	public String getAllProductList(Map<String, Object> m) {
		List<PurchaseModel> plList = purchServ.getAllProductList();
		m.put("plList", plList);
		m.put("page", "ViewProductList.jsp");
		return "UserDashboard";
	}

	/*
	 * ======================================ORDER-LIST-CONTROLLER==================  
	 * ================
	 */

	@RequestMapping(value = "/orderlist")
	public ModelAndView isOrderList(ModelAndView mv) {

		mv.addObject("purch", "OrderList.jsp");

		List<PurchaseModel> plList = purchServ.getAllProductList();
		mv.addObject("plList", plList);

		List<ProductModel> prodList = prodServ.getAllProducts();
		
		mv.addObject("prodList", prodList);

		List<StockModel> stkList = stockServ.getAllUnit();
		mv.addObject("stkList", stkList);
        
		mv.setViewName("UserDashboard");

		return mv;
	}
     
	    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<   JSON    >>>>>>>>>>>>>>>>>>>>>>>>>>*/
	
	@RequestMapping(value = "/orderlists", method = RequestMethod.POST)
	public String isOrderList(@RequestBody String orderlists, Map<String, Object> map) throws IOException {
	  System.out.println(orderlists);
	  
		TypeToken<List<PurchaseModel>> typeToken = (TypeToken<List<PurchaseModel>>) TypeToken.getParameterized(List.class,PurchaseModel.class);
		List<PurchaseModel> orderlists1 = new Gson().fromJson(orderlists, typeToken.getType());
		System.out.println(orderlists1);
	    boolean b = purchServ.isCreateOrderList(orderlists1);
	    if(b){
	    	map.put("odrLstOk", "Product add succesfully...");
	    }else {
	    	map.put("odrLstOk", "Some problem to add product in list...");
	    }
	    
	    map.put("page", "ViewOrderList.jsp");		
	    return "redirect:orderListMap";
	}

	
	
	
	
	
	
	
/*=====================================================================================================*/
	@RequestMapping(value = "/deleteorderlist")
	public String deleteOrderList(@RequestParam("doid") Integer doid, Map<String, Object> map) {
		boolean b = purchServ.isDeleteOrderList(doid);

		return "redirect:vieworderlist";
	}

	/*
	 * =============================================================================
	 * =============
	 */
	/*
	 * @RequestMapping(value = "/vieworderlist", method = RequestMethod.GET) public
	 * String getAllOrderList(Map<String, Object> m) { List<PurchaseModel> olList =
	 * purchServ.getAllOrderList(); m.put("olList", olList); m.put("page",
	 * "ViewOrderList.jsp"); return "UserDashboard"; }
	 */

	/*
	 * ======================================PURCHASE-BILL-CONTROLLER===============
	 * ===================
	 */
	@RequestMapping("/purchasebill")
	public ModelAndView isPurchaseBill(ModelAndView mv) {
		mv.addObject("purch", "PurchaseBill.jsp");
		List<PurchaseModel> plList = purchServ.getAllProductList();
		mv.addObject("plList", plList);
		mv.setViewName("UserDashboard");
		return mv;
	}

	@RequestMapping(value = "/purchasebill", method = RequestMethod.POST)
	@ResponseBody
	public String isPurchaseBill(@RequestParam("productListId") Integer productListId, Map<String, Object> map, InvoiceModel incModel)
			throws IOException {
		
		List<InvoiceModel> prodByList=purchServ.getProductByListId(productListId);
		map.put("prodByList", prodByList);
		
		Gson gson=new Gson();
		return gson.toJson(prodByList);
	}
	
	
	@RequestMapping(value = "/purchasebills", method = RequestMethod.POST)
	@ResponseBody
	public String isPurchaseBill(@RequestBody String invoicelist, Map<String, Object> map,InvoiceModel invModel) throws IOException {

	    InvoiceModel invoicelist1 = new Gson().fromJson(invoicelist, InvoiceModel.class);
	    
       
	    
	boolean b =   purchServ.saveInvoiceBill(invoicelist1, invoicelist1.getPlist());
          if(b) {
        	  map.put("msg", "Invoice Inserted....");
          }else {
        	  map.put("msg", "Invoice Not Inserted....");
          }	  	
	    return "Invoice data processed successfully";
	}

	


	@RequestMapping(value = "/deletepurchbill")
	public String deletePurchaseBill(@RequestParam("dpbid") Integer dpbid, Map<String, Object> map) {
		boolean b = purchServ.isDeletePurchaseBill(dpbid);

		return "redirect:viewpurchasebill";
	}
	/*============================================================================*/

	@RequestMapping(value = "/viewinvoice")
	public String getAllPurchaseBill(Map<String, Object> m) {
		List<InvoiceModel> purchbillList = purchServ.getPurchaseBill();
		m.put("purchbillList", purchbillList);
		System.out.println("list is"+purchbillList);
		m.put("page", "ViewPurchaseBill.jsp");
		return "ViewPurchaseBill";
	}

	
/*===================================================================================*/
	
	@RequestMapping("/allPurchases")
    public String showAllPurchases(Model m) {
        List<PurchaseModel> purchases = purchServ.findAllPurchases();
        m.addAttribute("purchases", purchases);
       
        return "ViewOrderList";
    }

	
	
    @RequestMapping("/orderListMap")
    public String showOrderListMap(Model m,Map<String, Object> map) {
        Map<String, List<PurchaseModel>> orderListMap = purchServ.getOrderListMap();
        m.addAttribute("orderListMap", orderListMap);
        map.put("vworderPage", "ViewOrderList.jsp");
        return "UserDashboard"; 
    }
    
 /*==========================================================================================================*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
