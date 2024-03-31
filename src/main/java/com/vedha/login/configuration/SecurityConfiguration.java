package com.vedha.login.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeHttpRequests(
                        req -> req.requestMatchers("/spring/register/**").permitAll()
                                .requestMatchers("/spring/login/**").permitAll()
                                .anyRequest().authenticated()
                );

        httpSecurity.formLogin(
                form -> form
                        .loginPage("/spring/login")
                        .loginProcessingUrl("/spring/login")
                        .defaultSuccessUrl("/spring/home")
                        .permitAll()
                );

        httpSecurity.logout(
                logout -> logout.logoutUrl("/spring/logout").permitAll()
        );

        return httpSecurity.build();
    }
}
