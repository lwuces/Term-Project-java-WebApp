package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.ui.LoginPage;
import com.vaadin.flow.spring.security.VaadinWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow anyone to access the login page
        http.authorizeHttpRequests( auth -> auth
        .requestMatchers( "/", "/login" ).permitAll()
        );
        
        // Require the "Admin" role to access the H2 console
        http.authorizeHttpRequests( auth -> auth
        .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
        .hasRole("Admin")
        );
        
        // Super
        super.configure(http);
        setLoginView(http, LoginPage.class);
    }

    // Demo for Test web only
    @Bean
    UserDetailsManager userDetailsService() throws Exception{
        UserDetails admin = User.withUsername("Admin")
                                .password("{noop}Admin")
                                .roles("Admin", "User")
                                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
