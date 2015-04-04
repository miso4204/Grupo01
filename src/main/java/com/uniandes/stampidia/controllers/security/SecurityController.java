package com.uniandes.stampidia.controllers.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpUser;

@RestController
@RequestMapping("/rest")
public class SecurityController {
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public StmpUser user(StmpUser user){
		return user;
	}
	
}
