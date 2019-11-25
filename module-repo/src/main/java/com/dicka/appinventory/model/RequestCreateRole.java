package com.dicka.appinventory.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class RequestCreateRole implements Serializable {

    @NotBlank(message = "role id cannot be null.")
    private String roleId;

    @NotBlank(message = "role name cannot be null.")
    private String roleName;

    public RequestCreateRole(){}

    public RequestCreateRole(String roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
