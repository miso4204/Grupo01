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
import javax.swing.text.html.HTML;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

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
		if (request.getMethod() != "OPTIONS" && !request.getRequestURI().contains("/rest/doLogin")) {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Authorization,Content-Type");
			response.setHeader("Access-Control-Max-Age", "3600");
			filterChain.doFilter(request, response);
		} else if(request.getRequestURI().contains("/rest/doLogin")){
			// Se usa este caso para invalidar el httpbasic session
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
}
