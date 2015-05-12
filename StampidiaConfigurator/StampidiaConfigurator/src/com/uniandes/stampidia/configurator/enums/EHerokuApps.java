package com.uniandes.stampidia.configurator.enums;

public enum EHerokuApps {
	ROOKIE ("stampidia-rookie"),
	STARTUP ("stampidia-startup"),
	BUSINESS ("stampidia-business");
	
    private final String name;       

    private EHerokuApps(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}
