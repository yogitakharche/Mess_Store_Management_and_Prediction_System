package oo.uu.Springmvc.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import oo.uu.Springmvc.Model.ProductModel;
import oo.uu.Springmvc.Model.UserModel;
import oo.uu.Springmvc.Service.ProductService;


@Controller
public class ProductController {
	
	@RequestMapping(value = "/product", method = RequestMethod.GET) 
	public String AddProductpage( Map<String, Object> m) {
		List<ProductModel> prodList = prodServ.getAllProducts();
		m.put("prodList", prodList);
		 m.put("page","AddProduct.jsp");
		return "UserDashboard";
		
	}
	
	  @RequestMapping(value = "/addproduct", method = RequestMethod.GET) 
	  public String AddProductform( Map<String, Object> m) { 
		  List<ProductModel> prodList = prodServ.getAllProducts();
			m.put("prodList", prodList);
		   m.put("page","AddProduct.jsp");
	  return"UserDashboard"; 
	  }
	 
/*========================  ADD-PRODUCT  ===========================*/
    @Autowired
	ProductService prodServ;
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String isAddProduct(ProductModel pModel, Map<String, Object> m) {
		boolean b = prodServ.isAddProduct(pModel);
		List<ProductModel> prodList = prodServ.getAllProducts();
		m.put("prodList", prodList);
		 m.put("page","AddProduct.jsp");
		return "UserDashboard";
	}
	
/*========================  VIEW-PRODUCT  ==========================*/
	
	@RequestMapping(value = "/viewproduct", method = RequestMethod.GET)
	public String getAllProduct(ProductModel pModel, Map<String, Object> m) {
		List<ProductModel> prodList = prodServ.getAllProducts();
		m.put("prodList", prodList);
		 m.put("page","ViewProduct.jsp");
		return "UserDashboard";
	}
	
/*========================  DELETE-PRODUCT  ==========================*/
	
	@RequestMapping(value = "/deleteproduct{dpid}", method = RequestMethod.GET)
	public String isDeleteProduct(@RequestParam("dpid") Integer prodId, Map<String, Object> m) {
    	boolean b = prodServ.isDeleteProduct(prodId);
    	List<ProductModel> prodList = prodServ.getAllProducts();
		m.put("prodList", prodList);
		 m.put("page","ViewProduct.jsp");
		return "UserDashboard";
	}
	
/*========================  UPDATE-PRODUCT  ==========================*/
	
	@RequestMapping(value="/updateproduct")
	public String GetUpdateform(@RequestParam ("upid") Integer upid, @RequestParam ("prodName") String prodName, Map<String,Object> m) {
		ProductModel prodModel=new ProductModel();
		
		System.out.println(upid+"<--id, name-->"+prodName);
		
		
		prodModel.setProdId(upid);
		prodModel.setProdName(prodName);
		m.put("temp",prodModel);
		m.put("UpdateProdPage","UpdateProduct.jsp");
		return "UserDashboard";
	}
	
	@RequestMapping(value="/updateProd")
	public String UpdatePage(ProductModel pmodel,Map<String, String> map) {
		
		  boolean b=prodServ.isUpdateProduct(pmodel);
		  if(b) { 
			  map.put("msg","product update Successfully........");
			  } else {
				  map.put("msg","product not update........");
				  }
		  
		  return "AddProduct";
		
	}

}
