package com.vedha.login.security;

import com.vedha.login.entity.UserEntity;
import com.vedha.login.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity byUserNameOrUserEmail = userRepository.findByUserNameOrUserEmail(username, username);

        if (byUserNameOrUserEmail == null) {

            throw new UsernameNotFoundException("User Not Found");
        }else {

            List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(byUserNameOrUserEmail.getUserEmail(), byUserNameOrUserEmail.getUserPassword(), simpleGrantedAuthorities);
        }
    }
}
