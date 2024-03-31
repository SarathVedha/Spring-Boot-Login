package com.vedha.login.dto;

import com.vedha.login.entity.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty(message = "*Name Should Not Be Empty")
    private String userName;

    @NotEmpty(message = "*Password Should Not Be Empty")
    private String userPassword;

    @NotEmpty(message = "*Email Should Not Be Empty")
    @Email(message = "*Invalid Email Format")
    private String userEmail;

    private List<RoleEntity> roleEntities;
}
