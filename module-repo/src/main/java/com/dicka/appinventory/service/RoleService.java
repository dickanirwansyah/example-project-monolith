package com.dicka.appinventory.service;

import com.dicka.appinventory.entity.Role;
import com.dicka.appinventory.model.RequestCreateRole;

import java.util.ArrayList;
import java.util.Optional;

public interface RoleService {
    ArrayList<Role> listRole();
    Role findRoleByName(String name);
    Role createRole(RequestCreateRole createRole);
    Role updateRole(String id, RequestCreateRole updateRole);
    Role findRoleById(String id);
}
