package com.dicka.appinventory.model;

import com.dicka.appinventory.validation.validator.UsernameIsExistingValidator;
import com.dicka.appinventory.validation.validator.UsernameValidator;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class RequestCreateUsers implements Serializable {

    @NotBlank(message = "name cannot be null")
    private String reqName;


    //@UsernameValidator
    //@UsernameIsExistingValidator
    @NotBlank(message = "username cannot be null")
    private String reqUsername;

    private String reqPicture;

    private boolean reqStatus;

    @NotBlank(message = "password cannot be null")
    private String reqPassword;

    private List<RequestRole> requestRoles;

    public RequestCreateUsers(){}

    public RequestCreateUsers(String reqName, String reqUsername,String reqPicture, boolean reqStatus, String reqPassword, List<RequestRole> requestRoles){
        this.reqName = reqName;
        this.reqUsername = reqUsername;
        this.reqPicture = reqPicture;
        this.reqStatus = reqStatus;
        this.reqPassword = reqPassword;
        this.requestRoles = requestRoles;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public String getReqUsername() {
        return reqUsername;
    }

    public void setReqUsername(String reqUsername) {
        this.reqUsername = reqUsername;
    }

    public String getReqPicture() {
        return reqPicture;
    }

    public void setReqPicture(String reqPicture) {
        this.reqPicture = reqPicture;
    }

    public boolean isReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(boolean reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getReqPassword() {
        return reqPassword;
    }

    public void setReqPassword(String reqPassword) {
        this.reqPassword = reqPassword;
    }

    public List<RequestRole> getRequestRoles() {
        return requestRoles;
    }

    public void setRequestRoles(List<RequestRole> requestRoles) {
        this.requestRoles = requestRoles;
    }
}
