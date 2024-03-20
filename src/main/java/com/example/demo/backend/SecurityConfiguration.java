package com.example.demo.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import com.example.demo.ui.LoginPage;
import com.vaadin.flow.spring.security.VaadinWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http); 
        setLoginView(http, LoginPage.class);
    }

    @Bean
    UserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
            User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build()
        );
    }
}
