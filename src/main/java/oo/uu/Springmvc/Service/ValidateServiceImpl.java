package oo.uu.Springmvc.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oo.uu.Springmvc.Model.UserModel;

import oo.uu.Springmvc.Repository.ValidateRepository;


@Service("validServ")
public class ValidateServiceImpl implements ValidateService{

	@Autowired
	ValidateRepository validRepo;
	
	@Override
	public boolean isValidateUser(UserModel vModel) {
		
		return validRepo.isValidateUser(vModel);
	}

	
	
	/* static String mail = "vaibhavsk06xxvi@gmail.com";
	    static String password = "teyz jlfn pbki ngjz";

	    public static void send(String to, String sub, String msg) {
	        // Set properties
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");

	        // Get the session
	        Session session = Session.getDefaultInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(mail, password);
	            }
	        });

	        // Compose message
	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject(sub);
	            message.setText(msg);

	            // Send message
	            Transport.send(message);
	            System.out.println("Message sent successfully");
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }*/
}
