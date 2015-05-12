package com.uniandes.stampidia.configurator.enums;

public enum EProducts {
	ROOKIE ("Rookie"),
	STARTUP ("Startup"),
	BUSINESS ("Business");
	
    private final String name;       

    private EProducts(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}
