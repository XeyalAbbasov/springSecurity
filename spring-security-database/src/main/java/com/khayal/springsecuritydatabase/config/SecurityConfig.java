package com.khayal.springsecuritydatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    //authentication
    public UserDetailsService userDetailsService(){
//        UserDetails admin= User.withUsername("Xeyal")
//                .password(encoder.encode("123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user=User.withUsername("Aygun")
//                .password(encoder.encode("123"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin,user);

        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       return  http.csrf().disable()
                .authorizeHttpRequests() //bu authorizeRequests in alternatividir
                .requestMatchers("/products/welcome","/users/new").permitAll() //antMatchars
                .and()
                .authorizeHttpRequests().requestMatchers("/products/**")
                .authenticated().and()
               .formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
        public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
        // burada authenticationProvider userDetails ile danishir ve generet edir userDetails obyektini
        //ve bu authenticateiona obyektini teyin edecek
    }

}
