package com.vedha.login.repository;

import com.vedha.login.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByRoleName(String roleName);
}
