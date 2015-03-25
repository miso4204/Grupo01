 package com.uniandes.stampidia.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(PersistencesJPAConfig.class);
		ctx.register(WebMvcConfig.class);
		ctx.setServletContext(servletContext);	
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		MultipartConfigElement mpp = new MultipartConfigElement("/tmp", 25 * 1024 * 1024, 125 * 1024 * 1024, 1 * 1024 * 1024); 
		servlet.setMultipartConfig(mpp);
		servlet.setLoadOnStartup(1);
	}
	

	
}
