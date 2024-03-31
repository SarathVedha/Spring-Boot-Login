package com.vedha.login.repository;

import com.vedha.login.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserNameOrUserEmail(String userName, String userEmail);
}
