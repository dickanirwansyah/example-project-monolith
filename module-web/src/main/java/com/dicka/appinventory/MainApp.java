package com.dicka.appinventory;

import com.dicka.appinventory.entity.Role;
import com.dicka.appinventory.model.RequestCreateUsers;
import com.dicka.appinventory.model.RequestRole;
import com.dicka.appinventory.repository.RoleRepository;
import com.dicka.appinventory.service.RoleService;
import com.dicka.appinventory.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args){
        SpringApplication.run(MainApp.class, args);
    }
}

//@Component
//class CommandData implements CommandLineRunner{
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Object[]> rolesObject = roleRepository.roleByUsersId(2);
//        for (Object[] o : rolesObject){
//            /** [0], [1] .. [], [] array sekian adalah field object yang ingin ditampilkan **/
//            /** semisal -> id, name, status dkk.. **/
//            System.out.println(String.format("| %s |  %s |", o[0], o[1]));
//        }
//    }
//}

//@Component
//class CommandData implements CommandLineRunner {
//
//    @Autowired
//    private UsersService usersService;
//
//    private static final Logger log = LoggerFactory.getLogger(CommandData.class);
//
//    @Override
//    public void run(String... args) throws Exception {
//        RequestCreateUsers requestCreateUsers = new RequestCreateUsers();
//        RequestRole requestRole = new RequestRole();
//
//
//
//        List<RequestRole> requestRoles = new ArrayList<>();
//        String roleIds[] = {"r001", "r002"};
//        for (int i=0; i < roleIds.length; i++){
//            requestRole.setRoleId(roleIds[i]);
//            requestRoles.add(requestRole);
//        }
//        requestCreateUsers.setReqName("fanny oktaviani");
//        requestCreateUsers.setReqPassword("rootroot");
//        requestCreateUsers.setReqStatus(false);
//        requestCreateUsers.setReqUsername("fannyoktvn");
//        requestCreateUsers.setReqPicture("image.png");
//        requestCreateUsers.setRequestRoles(requestRoles);
//
//
//        usersService.createsUsers(requestCreateUsers);
//    }
//}

