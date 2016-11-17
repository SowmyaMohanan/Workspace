package com.angular;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.angular.config.WebMvcConfig;

public class WebInitializer implements WebApplicationInitializer{

	private static final String CONFIG_PATH = "com.angular.config";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//context.setConfigLocation(CONFIG_PATH);
		context.register(WebMvcConfig.class);
		context.setServletContext(servletContext);
		
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("DispatcherServlet", servlet);
		
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
	}

}
