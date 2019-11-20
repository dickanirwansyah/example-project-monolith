package com.dicka.appinventory.model;

import java.io.Serializable;
import java.util.List;

public class ResponseLogin {

    private int usersId;
    private String username;
    private String picture;
    private boolean status;
    //private List<Object[]> rolesObject;
    private List<ResponseRole> responseRoles;

    public ResponseLogin(){}

    public ResponseLogin(int usersId, String username, String picture, boolean status,
                         List<ResponseRole> responseRoles) {
        this.usersId = usersId;
        this.username = username;
        this.picture = picture;
        this.status = status;
        this.responseRoles = responseRoles;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public List<ResponseRole> getResponseRoles() {
        return responseRoles;
    }

    public void setResponseRoles(List<ResponseRole> responseRoles) {
        this.responseRoles = responseRoles;
    }
}

