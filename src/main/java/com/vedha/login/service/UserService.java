package com.vedha.login.service;

import com.vedha.login.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO saveUsers(UserDTO userDTO);

    public UserDTO isUserExist(UserDTO userDTO);

    public List<UserDTO> getAllUsers();
}
