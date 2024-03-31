package com.vedha.login.service.impl;

import com.vedha.login.dto.UserDTO;
import com.vedha.login.entity.RoleEntity;
import com.vedha.login.entity.UserEntity;
import com.vedha.login.repository.RoleRepository;
import com.vedha.login.repository.UserRepository;
import com.vedha.login.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDTO saveUsers(UserDTO userDTO) {

        // For Encrypt using spring security
        userDTO.setUserPassword(userDTO.getUserPassword());

        RoleEntity roleAdmin = roleRepository.findByRoleName("ROLE_ADMIN");

        if (roleAdmin == null) {

            roleAdmin = createRole();
        }

        userDTO.setRoleEntities(List.of(roleAdmin));

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        UserEntity save = userRepository.save(userEntity);

        return modelMapper.map(save, UserDTO.class);
    }

    @Override
    public UserDTO isUserExist(UserDTO userDTO) {

        UserEntity byUserNameOrUserEmail = userRepository.findByUserNameOrUserEmail(userDTO.getUserName(), userDTO.getUserEmail());

        return modelMapper.map(byUserNameOrUserEmail, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<UserEntity> all = userRepository.findAll();

        return all.stream().map(userEntity -> modelMapper.map(userEntity, UserDTO.class)).toList();
    }

    private RoleEntity createRole() {

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName("ROLE_ADMIN");

        return roleRepository.save(roleEntity);
    }

}
