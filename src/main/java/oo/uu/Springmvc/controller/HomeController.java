package oo.uu.Springmvc.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import oo.uu.Springmvc.Model.UserModel;
import oo.uu.Springmvc.Service.UserService;
import oo.uu.Springmvc.Service.ValidateService;

@Controller
public class HomeController {

	@Autowired
	UserService usrServ;
	 
	
/*================================  HOME-PAGE  ======================================*/
	@RequestMapping("/")
	public ModelAndView test(HttpServletRequest request) throws IOException {

		return new ModelAndView("home");
	}
	
/*===========================  INDEX-TO-LOGIN-PAGE  ==================================*/	

	@RequestMapping("/validateuser")
	public ModelAndView validateUser(HttpServletRequest request) throws IOException {

		return new ModelAndView("UserValidate");
	}
	
/*===========================  LOGIN-TO-INDEX-PAGE  ==================================*/	

	@RequestMapping("/indexpage")
	public ModelAndView logToIndex(HttpServletRequest request) throws IOException {

		return new ModelAndView("home");
	}
/*===========================  LOGIN-USER-TO-DASHBOARD  ==============================*/
	@Autowired
	ValidateService validServ;

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	
	public String isValidUser(UserModel vModel, Map<String, Object> m,HttpSession session) {
		
		boolean b = validServ.isValidateUser(vModel);
		if (b) {
			
			UserModel sdModel=usrServ.sessionData(vModel);
			
			session.setAttribute("User", sdModel);
	
				return "UserDashboard";	
		} else {
			m.put("msg", "invalid user....");
			     return "UserValidate";
		}
	}
	
/*================================  USER-PROFILE  ======================================*/
	@RequestMapping("/userprofile")
	public String getProfile(HttpSession session,Map<String, String> map,UserModel uModel) {
		
		map.put("UserPage", "UserProfile.jsp");
		return "UserDashboard";
		
	}
	
/*================================  CHART  ======================================*/
	@RequestMapping("/charting")
	public String getChart(Map<String, String> map,UserModel uModel) {
		
		map.put("Chart", "DashboardPredChart.jsp");
		return "UserDashboard";
		
	}
	
/*============================  APPLICATION-LOGOUT  ===============================*/	 
	@RequestMapping("/logout")
	public String getLOgOut(HttpSession session,Map<String, String> map,UserModel uModel) {
		if(session.getAttribute("User") != null) {
			session.removeAttribute("User");
		}
		return "UserValidate";
		
	}
	
/*===========================  EMAIL-INTEGRATION  ====================================*/
	    @Autowired
	    private JavaMailSender mailSender;

	    @RequestMapping("/sendemail")
	    public String SendEmail(Map<String, String> map) {
	    	map.put("EmailPage", "SendEmail.jsp");
	        return "UserDashboard"; 
	    }
	    @RequestMapping(value = "/SendEmails", method = RequestMethod.POST)
	    public String doSendEmail(HttpServletRequest request, Map<String, String> m) {
	       
	        String to = request.getParameter("to");
	        String subject = request.getParameter("subject");
	        String message = request.getParameter("message");
	       
	        System.out.println("Recipient Address: " + to);
	        System.out.println("Subject: " + subject);
	        System.out.println("Message: " + message);
	       
	        if (to == null || to.isEmpty() ||
	            subject == null || subject.isEmpty() ||
	            message == null || message.isEmpty()) {
	            return "Error";
	        }

	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(to);
	        email.setSubject(subject);
	        email.setText(message);

	        try {
	            mailSender.send(email);
	            m.put("m", "EMail Suceessfully send");

	        } catch (Exception e) {
	            e.printStackTrace(); 
	            request.setAttribute("exception", e);
	            return "Error";
	        }

	        m.put("EmailPage", "SendEmail.jsp");
	        return "UserDashboard";
	    }
/*===========================  USER-GUIDE  ====================================*/
	    @RequestMapping("/userguide")
		public String userGuide(Map<String, String> map) {
			
			map.put("UserPage", "UserGuide.jsp");
			return "UserDashboard";
			
		}
	    
	}
	

