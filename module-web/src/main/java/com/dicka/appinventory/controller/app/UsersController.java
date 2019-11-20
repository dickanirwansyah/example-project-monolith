package com.dicka.appinventory.controller.app;

import com.dicka.appinventory.entity.Users;
import com.dicka.appinventory.model.RequestCreateUsers;
import com.dicka.appinventory.model.RequestLogin;
import com.dicka.appinventory.model.ResponseLogin;
import com.dicka.appinventory.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<ArrayList<Users>> listUsers(){
        ArrayList<Users> users = usersService.usersList();
        if (users == null || users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> getUsersId(@PathVariable("id")int id){
        Users users = usersService.findById(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/by")
    public ResponseEntity<ArrayList<Users>> searchUsersByName(@RequestParam("name")String name){
        ArrayList<Users> users = usersService.searchUsersByName(name);
        if (users.isEmpty() || users == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseLogin> loginUsers(@RequestBody @Valid RequestLogin requestLogin){
        ResponseLogin responseLogin = usersService.findUsersAndPassword(requestLogin);
        return new ResponseEntity<>(responseLogin, HttpStatus.OK);
    }

    @PostMapping(value = "/create-users")
    public ResponseEntity<Users> createUsers(@RequestBody @Valid RequestCreateUsers createUsers){
        Users users = usersService.createsUsers(createUsers);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }
}
