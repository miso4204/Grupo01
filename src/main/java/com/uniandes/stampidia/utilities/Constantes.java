package com.uniandes.stampidia.utilities;

public enum Constantes {
    SUCCESS_RESULT("Resultado exitoso");

    private String description;

    private Constantes(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
