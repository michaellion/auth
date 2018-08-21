package com.auth.Config;

import com.auth.Service.CustomDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 public void config(AuthenticationManagerBuilder auth) throws Exception{
  auth.userDetailsService(customDetailsService());
 }

 @Bean
  UserDetailsService customDetailsService(){
    return new CustomDetailsService();

  }

  public void config(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll();
  }
}
