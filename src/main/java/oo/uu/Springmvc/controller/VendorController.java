package oo.uu.Springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import oo.uu.Springmvc.Model.UserModel;
import oo.uu.Springmvc.Model.VendorModel;
import oo.uu.Springmvc.Service.VendorService;

@Controller
public class VendorController {

/*========================  ADD-VENDOR  ===========================*/
	@Autowired
	VendorService vendServ;
	
	
	
	
	
	
	@RequestMapping(value = "/addvendor", method = RequestMethod.GET)
	public String isAddVendor(VendorModel vModel, Map<String, Object> m) {
		boolean b = vendServ.isAddVendor(vModel); 
		
    	m.put("page","AddVendor.jsp");
		return "UserDashboard";
	}
	
/*========================  VIEW-VENDOR  ==========================*/
	
	@RequestMapping(value = "/viewvendor", method = RequestMethod.GET)
	public String getAllVendor(VendorModel vModel, Map<String, Object> m) {
		List<VendorModel> vlist =vendServ.getAllVendor();
		m.put("vlist", vlist);
		 m.put("page","ViewVendor.jsp"); 
		return "UserDashboard";
	}
	
/*========================  DELETE-VENDOR  ==========================*/
	
	@RequestMapping(value = "/deletevendor{vdid}", method = RequestMethod.GET)
	public String isDeleteVendor(@RequestParam("vdid") Integer id, Map<String, Object> m) {
		boolean b = vendServ.isDeleteVendor(id);
		List<VendorModel> vlist =vendServ.getAllVendor();
		m.put("vlist", vlist);
		 m.put("page","ViewVendor.jsp"); 
		return "UserDashboard";
	}
	
/*========================  UPDATE-VENDOR  ==========================*/
	
	@RequestMapping(value = "/updatevendor", method = RequestMethod.GET)
	public String getVendorData(@RequestParam(value = "vuid", required = true) Integer vuid,
	                            @RequestParam(value = "name", required = false) String name,
	                            @RequestParam(value = "email", required = false) String email,
	                            @RequestParam(value = "contact", required = false) String contact,
	                            @RequestParam(value = "shopname", required = false) String shopname, Map<String, Object> m) {
	    VendorModel vendModel = new VendorModel();
	    vendModel.setId(vuid);
	    vendModel.setName(name);
	    vendModel.setEmail(email);
	    vendModel.setContact(contact);
	    vendModel.setShopname(shopname);
	    m.put("vend", vendModel);
	    List<VendorModel> vlist =vendServ.getAllVendor();
		m.put("vlist", vlist);
		m.put("VendUPdatePage", "UpdateVendor.jsp");
	    return "UserDashboard";
	}

	
	
	@RequestMapping(value = "updateVendForm", method = RequestMethod.GET)
	public String UpdatePage(@ModelAttribute VendorModel model, Map<String, Object> map) {
	    boolean isUpdated = vendServ.isUpdateVendor(model);
	    if (isUpdated) {
	        map.put("msg", "Vendor updated successfully.");
	    } else {
	        map.put("msg", "Vendor update failed.");
	    }
	    return "UpdateVendor";
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
