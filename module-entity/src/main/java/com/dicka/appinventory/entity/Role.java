package com.dicka.appinventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "in_role")
@Entity
public class Role implements Serializable {

    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<UsersRole> usersRoles;
}
