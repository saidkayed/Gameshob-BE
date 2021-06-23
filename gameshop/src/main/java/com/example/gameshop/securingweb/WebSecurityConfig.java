/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.securingweb;

import com.example.gameshop.jwt.JwtTokenVerifier;
import com.example.gameshop.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.gameshop.securingweb.UserRole.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author sidad
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder);
         
        return authProvider;
    }

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())  //generate xsrf token
        //.and()
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll() //Whitelist
                .antMatchers(HttpMethod.POST, "/api/user/**").permitAll()
                .antMatchers("/admin/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated();
    }
    /* REPLACED BY UserDetailsServiceImpl
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       
        
        UserDetails saidKayedUser = User.builder()
                .username("Said")
                .password(passwordEncoder.encode("password"))
                .roles(CUSTOMER.name())  //ROLE_CUSTOMER
                .build();

        UserDetails dianaKayedUser = User.builder()
                .username("diana")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())   //ROLE_ADMIN
                .build();

        return new InMemoryUserDetailsManager(
                saidKayedUser,
                dianaKayedUser
        );
    }
     */
}
