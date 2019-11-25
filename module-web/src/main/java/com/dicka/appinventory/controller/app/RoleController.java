package com.dicka.appinventory.controller.app;

import com.dicka.appinventory.entity.Role;
import com.dicka.appinventory.model.RequestCreateRole;
import com.dicka.appinventory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    private HashMap<String, String> hashMapValidation;

    @GetMapping
    public ResponseEntity<ArrayList<Role>> listRole(){
        ArrayList<Role> roles = roleService.listRole();
        if (roles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createRole(@RequestBody @Valid RequestCreateRole role,
                                           BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.BAD_REQUEST);
        }
        Role createdRole = roleService.createRole(role);
        return new ResponseEntity<Object>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> getId(@PathVariable("id")String id){
        Role entityRole = roleService.findRoleById(id);
        return new ResponseEntity<>(entityRole, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable("id")String id,
                                       @RequestBody @Valid RequestCreateRole role,
                                       BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.BAD_REQUEST);
        }

        Role entityRole = roleService.updateRole(id,role);
        return new ResponseEntity<>(entityRole, HttpStatus.CREATED);
    }
}
