package com.uniandes.stampidia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.uniandes.stampidia.filters.CorsFilter;
import com.uniandes.stampidia.filters.CsrfHeaderFilter;
import com.uniandes.stampidia.services.security.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailService userDetailsService;
	
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
//		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("user").password("password").roles("BUYER");
		auth.inMemoryAuthentication().withUser("user2").password("password").roles("SELLER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.httpBasic()
//				.and()
//			.authorizeRequests()
//				.antMatchers("/index.html", "/").permitAll()
//			.anyRequest().authenticated()
//				.and()
//			.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/")
//	            .deleteCookies("XSRF-TOKEN")
//	            .deleteCookies("JSESSIONID")
//	            .invalidateHttpSession(true)
//				.and()
//			.csrf().disable();
//				.csrfTokenRepository(csrfTokenRepository())
//				.and()			
//			.addFilterAfter(new CsrfHeaderFilter(),CsrfFilter.class)
//			.addFilterBefore(new CorsFilter(), CorsFilter.class);
	}
	
	private CsrfTokenRepository csrfTokenRepository(){
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
}
