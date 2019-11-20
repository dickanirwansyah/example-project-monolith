package com.dicka.appinventory.service;

import com.dicka.appinventory.entity.Role;

import java.util.ArrayList;
import java.util.Optional;

public interface RoleService {
    ArrayList<Role> listRole();
    Role findRoleByName(String name);
    Role createRole(Role role);
    Role updateRole(String id, Role role);
    Role findRoleById(String id);
}
