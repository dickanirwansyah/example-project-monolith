package com.dicka.appinventory.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class RequestLogin implements Serializable {

    @NotBlank(message = "username cannot be null.")
    private String username;

    @NotBlank(message = "password cannot be null.")
    private String password;

    public RequestLogin(){}

    public RequestLogin(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
