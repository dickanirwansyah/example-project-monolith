package com.dicka.appinventory.repository;

import com.dicka.appinventory.entity.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRoleRepository extends JpaRepository<UsersRole, Integer> {
}
