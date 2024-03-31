package com.vedha.login.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringConfiguration {

    @Bean
    public ModelMapper initModelMapper() {

        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder () {

        return NoOpPasswordEncoder.getInstance();
    }
}
