package com.dicka.appinventory.service;

import com.dicka.appinventory.entity.Users;
import com.dicka.appinventory.model.RequestCreateUsers;
import com.dicka.appinventory.model.RequestLogin;
import com.dicka.appinventory.model.ResponseLogin;

import java.util.ArrayList;

public interface UsersService {
    ArrayList<Users> usersList();
    ArrayList<Users> searchUsersByName(String name);
    ResponseLogin findUsersAndPassword(RequestLogin requestLogin);
    Users findById(int id);
    Users findByUsername(String username);
    Users createsUsers(RequestCreateUsers requestCreateUsers);
    void disabledStatus(boolean status, int usersId);
    void enabledStatus(boolean status, int usersId);
}
