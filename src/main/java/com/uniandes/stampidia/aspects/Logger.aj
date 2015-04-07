package com.uniandes.stampidia.aspects;

public aspect Logger {
	
	//Se declara un pointcut para todos los metodos del paquete mundo
	pointcut logger():
		call(* com.uniandes.stampidia.services..* (..));
	
	//Se imprimen el nombre del metodo, parametros y objeto sobre el que se invoca
	before() : logger(){
		System.out.println("Nombre método: " + thisJoinPointStaticPart.getSignature());
		System.out.println("Parametros:" + thisJoinPoint.getArgs().toString());
		System.out.println("Objeto sobre el que se invoca:" + thisJoinPoint.getTarget());
	}
	
	//Se imprime el resultado de ejecucion exitosa
	after() returning (Object r) : logger(){
		System.out.println("Resultado: " + r);
	}
	
	//Se imprime la excepcion de ejecucion no exitosa
	after() throwing (Throwable e) : logger(){
		System.out.println("Excepción: " + e);
	}

}