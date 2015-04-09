package com.uniandes.stampidia.controllers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.services.UserService;
import com.uniandes.stampidia.utilities.Resultado;

/**
 * Controlador encargado de validar el usuario que se encuentra actualmente 
 * logueado
 * 
 * @author Diego Agudelo
 */
@RestController
@RequestMapping(value="/rest")
public class SecurityController {

	/**
	 * Servicio spring utilizado para consultar la informacion del(los) usuario(s)
	 */
	@Autowired
    private UserService userService;
	
	/**
	 * Servicio que recibe un nombre de usuario 
	 * @param username
	 * @return user - la informacion del usuario solicitado
	 */
	@RequestMapping(value="/loggedUser/{username}",method=RequestMethod.GET)
	public Resultado user(@PathVariable String username){
		Resultado result = new Resultado();
		StmpUser user = new StmpUser();
		user.setUsername(username);
		result.setResultado(user);
		return result;
	}
	
}
