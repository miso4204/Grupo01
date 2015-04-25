package com.uniandes.stampidia.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.uniandes.stampidia.filters.CorsFilter;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebMvcConfig.class, PersistencesJPAConfig.class, SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[]{new CorsFilter(),new MultipartFilter()};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		MultipartConfigElement mpp = new MultipartConfigElement("/", 25 * 1024 * 1024, 125 * 1024 * 1024, 1 * 1024 * 1024); 
		registration.setMultipartConfig(mpp);
	}

}
