package com.school.student.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user1").password("password").roles("USER")
                .and().withUser("user2").password("password").roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().and()
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        http
        .authorizeRequests()
                .antMatchers("/**").hasAnyRole("USER","ADMIN")
                .anyRequest()
                .authenticated().and().formLogin();
    }
}
