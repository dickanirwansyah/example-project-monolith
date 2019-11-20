package com.dicka.appinventory.repository;

import com.dicka.appinventory.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT u FROM Users u WHERE u.name LIKE CONCAT('%',:name,'%')")
    List<Users> findUsersByName(@Param("name")String name);

    @Query("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password")
    Optional<Users> findUsersByUsernameAndPassword(@Param("username")String username,
                                                  @Param("password")String password);

    Optional<Users> findUsersByUsername(String username);
}
