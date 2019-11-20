package com.dicka.appinventory.service.impl;

import com.dicka.appinventory.entity.Role;
import com.dicka.appinventory.exception.ResourceIsExistingException;
import com.dicka.appinventory.exception.ResourceNotFoundException;
import com.dicka.appinventory.repository.RoleRepository;
import com.dicka.appinventory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public ArrayList<Role> listRole() {
        ArrayList<Role> roles = new ArrayList<>();
        List<Role> roleRepos = roleRepository.findAll();
        for (Role role : roleRepos){
            roles.add(role);
        }
        return roles;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("name : "+name+" not found"));
    }

    @Override
    public Role createRole(Role role) {

        Optional<Role> roleNname = roleRepository.findRoleByName(role.getName());
        Optional<Role> roleId = roleRepository.findById(role.getId());
        Role entityRole = null;

        if (roleId.isPresent()){
            throw new ResourceIsExistingException("role id "+role.getId()+" is existing !");
        }

        if (roleNname.isPresent()){
            throw new ResourceIsExistingException("role name "+role.getName()+" is existing !");
        }

        entityRole = new Role();
        entityRole.setId(role.getId());
        entityRole.setName(role.getName());
        roleRepository.save(entityRole);
        return entityRole;
    }

    private Role findExistingRoleByName(String roleName){
        Role role = roleRepository.findByName(roleName);
        return role;
    }

    @Override
    public Role updateRole(String id, Role role) {
        Role entityRole = roleRepository.findRoleById(id);
        if (entityRole == null){
            throw new ResourceNotFoundException("id role "+id+" not found");
        }else{
            entityRole = Role
                    .builder()
                    .name(role.getName())
                    .build();
            roleRepository.save(entityRole);
        }
        return entityRole;
    }

    @Override
    public Role findRoleById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("id role "+id+" not found"));
    }
}
