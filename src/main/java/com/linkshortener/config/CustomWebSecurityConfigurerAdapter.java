package com.linkshortener.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and().httpBasic()
                .and().sessionManagement().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //root
        auth.inMemoryAuthentication().withUser("user").password("$2a$12$HUtJiw2tZI2.3XSlsaFW8OKStQmF9h6VQz.AtmtlehhZNoo1SmXPO").roles("USER");
        //pass
        auth.inMemoryAuthentication().withUser("user1").password("$2a$12$1BHUAUizHmUz.JIaDFvRlO.CZu9SCGjQRe5Y7/7hQEF9DG5E6VRji").roles("USER");
        //ssap
        auth.inMemoryAuthentication().withUser("user2").password("$2a$12$AjTrh8cO8A3KxRhsjZy/pe5Z9UXJX.tmKD4hj.lcFh22JzGBprHfK").roles("USER");
    }
}