package com.uniandes.stampidia.utilities;

import com.uniandes.stampidia.utilities.enums.EStatusType;

/**
 * Created by SEBASTIAN on 03/04/2015.
 */
public class Status {
    private EStatusType type;
    private String description;

    public EStatusType getType() {
        return type;
    }

    public void setType(EStatusType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
