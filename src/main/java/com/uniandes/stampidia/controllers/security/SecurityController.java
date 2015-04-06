package com.uniandes.stampidia.controllers.security;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpUser;

@RestController
@RequestMapping(value="/rest")
public class SecurityController {

	@RequestMapping(value="/loggedUser",method=RequestMethod.GET)
	public StmpUser user(StmpUser user){
		return user;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String[] login(@RequestBody String username, @RequestBody String password){
		if("user".equals(username)){
			return new String[]{"user","password","token"};
		}
		return new String[]{};
	}
	
}
