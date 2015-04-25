package com.uniandes.stampidia.aspects;

import org.apache.log4j.Logger;

public aspect LoggerAspect {
	
	private static Logger log = Logger.getLogger(LoggerAspect.class);
	
	//Se declara un pointcut para todos los metodos del paquete mundo
	pointcut logger():
		execution(* com.uniandes.stampidia.controllers..* (..)) || execution(* com.uniandes.stampidia.services..* (..));
	
	//Se imprimen el nombre del metodo, parametros y objeto sobre el que se invoca
	before() : logger(){
		log.info("Entra a [" + thisJoinPointStaticPart.getSignature().toShortString() + "]");
	}
	
	//Se imprime el resultado de ejecucion exitosa
	after() returning (Object r) : logger(){
		log.info("Sale de [" + thisJoinPointStaticPart.getSignature().toShortString() + "]");
	}
	
	//Se imprime la excepcion de ejecucion no exitosa
	after() throwing (Throwable e) : logger(){
		log.info("Excepción: " + e);
	}

}