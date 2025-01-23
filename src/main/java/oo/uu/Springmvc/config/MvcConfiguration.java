package oo.uu.Springmvc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "oo.uu.Springmvc")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/JSP/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// local
	
	  @Bean(name = "datasource") public DriverManagerDataSource getDataSource() {
	  DriverManagerDataSource datasource = new DriverManagerDataSource();
	  datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	  datasource.setUrl("jdbc:mysql://localhost:3306/storepredict");
	  datasource.setUsername("root"); datasource.setPassword("vk2724"); return
	  datasource; }
	 

	

	@Bean(name = "template")
	public JdbcTemplate getData() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("mail here");
		mailSender.setPassword("auth pass here");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

//	 @Bean
//	 public CommonsMultipartResolver multipartResolver() {
//	     CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//	     resolver.setDefaultEncoding("utf-8");
//	     resolver.setMaxUploadSize(10485760); // 10 MB
//	     return resolver;
//	 }
//}
}