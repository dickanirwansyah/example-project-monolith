package com.dicka.appinventory.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

public class RequestRole implements Serializable {

    @NotBlank(message = "id role cannot be null")
    private String roleId;

    public RequestRole(){}

    public RequestRole(String roleId){
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
