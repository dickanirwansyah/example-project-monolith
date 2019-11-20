package com.dicka.appinventory.repository;

import com.dicka.appinventory.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findRoleByName(String name);

    Role findByName(String name);


    Role findRoleById(String id);

    @Query(value = "select ir.id, ir.name from in_role ir join in_users_role iur on ir.id=iur.id_role where iur.id_users=:usersId", nativeQuery = true)
    List<Object[]> roleByUsersId(@Param("usersId")int usersId);
}
