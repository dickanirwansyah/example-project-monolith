package com.dicka.appinventory.service.impl;

import com.dicka.appinventory.entity.Role;
import com.dicka.appinventory.entity.Users;
import com.dicka.appinventory.entity.UsersRole;
import com.dicka.appinventory.exception.ResourceNotFoundException;
import com.dicka.appinventory.model.*;
import com.dicka.appinventory.repository.RoleRepository;
import com.dicka.appinventory.repository.UsersRepository;
import com.dicka.appinventory.repository.UsersRoleRepository;
import com.dicka.appinventory.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRoleRepository usersRoleRepository;

    @Override
    public ArrayList<Users> usersList() {
        List<Users> users = usersRepository.findAll(Sort.by("createdAt").ascending());
        ArrayList<Users> listUsers = new ArrayList<>();
        for (Users dataUsers : users){
            listUsers.add(dataUsers);
        }
        return listUsers;
    }

    @Override
    public ArrayList<Users> searchUsersByName(String name) {
        List<Users> users = usersRepository.findUsersByName(name);
        ArrayList<Users> listUsers = new ArrayList<>();
        for (Users dataUsers: users){
            listUsers.add(dataUsers);
        }
        return listUsers;
    }

    @Override
    public ResponseLogin findUsersAndPassword(RequestLogin requestLogin) {

        ResponseLogin responseLogin = new ResponseLogin();
        RequestLogin authSession = null;

        Users users = usersRepository
                .findUsersByUsernameAndPassword(requestLogin.getUsername(), requestLogin.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("USER WITH : "
                        +requestLogin.getUsername()+ " NOT FOUND !"));

        if (users.isStatus() == false)
            throw new ResourceNotFoundException("YOUR ACCOUNT IS EXPIRED, PLEASE CALL ADMIN !");


            List<Object[]> responseRoleByUsersId = roleRepository.roleByUsersId(users.getId());
            List<ResponseRole> responseRoles = new ArrayList<>();

            for (Object[] o: responseRoleByUsersId){
                ResponseRole responseRole = new ResponseRole();
                responseRole.setId(o[0].toString());
                responseRole.setName(o[1].toString());
                responseRoles.add(responseRole);
            }

            responseLogin.setUsersId(users.getId());
            responseLogin.setPicture(users.getPicture());
            responseLogin.setStatus(users.isStatus());
            responseLogin.setUsername(users.getUsername());
            responseLogin.setResponseRoles(responseRoles);

        return responseLogin;
    }

    @Override
    public Users findById(int id) {
       return usersRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException(id + " NOT FOUND"));
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findUsersByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException(username + " NOT FOUND"));
    }

    @Override
    @Transactional
    public Users createsUsers(RequestCreateUsers requestCreateUsers) {

        Users users = new Users();
        users.setName(requestCreateUsers.getReqName());
        users.setPassword(requestCreateUsers.getReqPassword());
        users.setPicture(requestCreateUsers.getReqPicture());
        users.setUsername(requestCreateUsers.getReqUsername());
        users.setStatus(false);
        users.setCreatedAt(new Date());
        users.setUpdatedAt(new Date());

        /** test log users **/
        System.out.println(String.format(" | %s | %s | %s ",
                users.getName(), users.getUsername(), users.getPassword()));

        usersRepository.save(users);

        /** get role **/
        Role role = null;
        UsersRole usersRole = null;

        for (RequestRole requestRole : requestCreateUsers.getRequestRoles()){
            role = roleRepository.findRoleById(requestRole.getRoleId());
            usersRole = new UsersRole();
            usersRole.setRole(role);
            usersRole.setUsers(users);
            usersRole.setUpdatedAt(new Date());
            usersRole.setCreatedAt(new Date());

            System.out.println(String.format("| %s | %s |",
                    usersRole.getRole().getName(), usersRole.getUsers().getName()));
            usersRoleRepository.save(usersRole);
        }

        return users;
    }

    @Override
    public void disabledStatus(boolean status, int usersId) {
        Users users = usersRepository.findById(usersId)
                .orElseThrow(()-> new ResourceNotFoundException("id : "+usersId+" not found."));
        users.setStatus(status);
        usersRepository.save(users);
    }

    @Override
    public void enabledStatus(boolean status, int usersId) {
        Users users = usersRepository.findById(usersId)
                .orElseThrow(() -> new ResourceNotFoundException("id : "+usersId+" not found."));
        users.setStatus(status);
        usersRepository.save(users);
    }
}
