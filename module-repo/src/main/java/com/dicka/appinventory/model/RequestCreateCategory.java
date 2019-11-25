package com.dicka.appinventory.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class RequestCreateCategory implements Serializable {

    @NotBlank(message = "name cannot be null.")
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
