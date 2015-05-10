package com.uniandes.stampidia.aspects;

import com.uniandes.stampidia.utilities.SendEmail;
import com.uniandes.stampidia.services.ShirtService;
import com.uniandes.stampidia.services.StampService;

public aspect SocialNetworks {

	pointcut mailer():
		call(* ShirtService.getSalesById(..)) || call (* StampService.getSalesById(..));

	before() : mailer(){
		System.out.println("Va a buscar las ventas de las estampas para SocialNetworking") ;
	}
	
	after() returning (Object r) : mailer() {
		System.out.println("Después de encontrar las ventas para SocialNetworking") ;
		SendEmail.send();
	}
}