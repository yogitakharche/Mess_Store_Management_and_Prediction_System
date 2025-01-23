package oo.uu.Springmvc.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import oo.uu.Springmvc.Model.UserModel;
import oo.uu.Springmvc.Service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService usrServ;
	
/*========================  SignIn-USER  ===========================*/	
	@RequestMapping(value = "/signinuser", method = RequestMethod.POST)
	public String isSignInUser(UserModel uModel, Map m) {
		boolean b= usrServ.isAddUser(uModel);
		if(b) {
			System.out.println("user adddddd");
		}else {
			System.out.println("user not adddddd");
		}
		System.out.println(usrServ.isAddUser(uModel));
		return "UserValidate";
	}
	
/*========================  VIEW-USER  ==========================*/
	
	@RequestMapping(value ="/viewuser",method = RequestMethod.GET)
	public String getAllUser( Map<String, Object> m) {
	 List<UserModel> ulist = usrServ.getAllUser();
	 m.put("ulist", ulist);
		 m.put("page","AddUser.jsp"); 
		return "UserDashboard";
	}
	
/*========================  DELETE-USER  ==========================*/
	
	@RequestMapping(value = "/deleteuser",method = RequestMethod.GET)
	public String isDeleteUser(@RequestParam ("id") Integer id, Map<String, Object> m) {
		boolean b=usrServ.isDeleteUser(id);
		List<UserModel> ulist = usrServ.getAllUser();
		 m.put("ulist", ulist);
		 m.put("page","AddUser.jsp");
		return "UserDashboard";
	}
	
/*========================  UPDATE-USER  ==========================*/

	@RequestMapping(value="updateuser")
	public String GetUpdateform(@RequestParam ("uid") Integer uid, @RequestParam ("name")
	  String name,@RequestParam ("email") String email,@RequestParam ("contact")
	  String contact, Map<String,Object> m) {
		 UserModel usModel=new UserModel();
		 usModel.setId(uid);
		 usModel.setName(name);
	     usModel.setEmail(email);
	     usModel.setContact(contact);
		m.put("temp",usModel);
		List<UserModel> ulist = usrServ.getAllUser();
		 m.put("ulist", ulist);
		m.put("UpdatePage","UpdateUser.jsp");
		return "UserDashboard";
	}
	
	@RequestMapping(value="updateForm")
	public String UpdatePage(UserModel model,Map<String, String> map) {
		boolean b=usrServ.isUpdateUser(model);
		if(b) {
			map.put("msg", "user update Successfully........");
		}
		else {
			map.put("msg", "user not update........");
		}
		
		
		return "UpdateUser";
		
	}
	
	
	
/*==========================================================================================*/
	
	
}
