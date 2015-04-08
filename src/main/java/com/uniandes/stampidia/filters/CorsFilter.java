package com.uniandes.stampidia.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Clase utilizada para "filtrar" las solicitudes hechas por fuera del servidor
 * 
 * @author Diego Agudelo
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Authorization,Content-Type");
		response.setHeader("Access-Control-Max-Age", "3600");
		if (request.getMethod() != "OPTIONS") {
			filterChain.doFilter(request, response);
		} else {
			// TODO se debe añadir una cabecera en el caso de options para el preflight de angular
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
}
