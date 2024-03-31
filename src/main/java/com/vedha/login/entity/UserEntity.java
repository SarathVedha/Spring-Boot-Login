package com.vedha.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userLogin")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usersRoles",
            joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "roleId", referencedColumnName = "id") }
    )
    private List<RoleEntity> roleEntities = new ArrayList<>();
}
