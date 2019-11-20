package com.dicka.appinventory.controller.app;

import com.dicka.appinventory.entity.Role;
import com.dicka.appinventory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<ArrayList<Role>> listRole(){
        ArrayList<Role> roles = roleService.listRole();
        if (roles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role createdRole = roleService.createRole(role);
        return new ResponseEntity<Role>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> getId(@PathVariable("id")String id){
        Role entityRole = roleService.findRoleById(id);
        return new ResponseEntity<>(entityRole, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Role> update(@PathVariable("id")String id,
                                       @RequestBody Role role){
        Role entityRole = roleService.updateRole(id,role);
        return new ResponseEntity<>(entityRole, HttpStatus.CREATED);
    }
}
