package com.fhb.web.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.rmi.server.ExportException;

import static org.springframework.security.authorization.AuthorizationManagers.allOf;
import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasAuthority;
import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasRole;



import static jakarta.servlet.DispatcherType.ERROR;
import static jakarta.servlet.DispatcherType.FORWARD;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private CustomDetailUserService userDetailsService;

    @Autowired
    public SecurityConfig(CustomDetailUserService userDetailsService){
            this.userDetailsService= userDetailsService;
    }

    @Bean
    public  static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    public void configure(AuthenticationManagerBuilder builder) throws Exception{
//        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }


    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                // https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
                .authorizeHttpRequests(authorize -> authorize
                        .dispatcherTypeMatchers(FORWARD, ERROR).permitAll()
                        .requestMatchers(
                                //file access

                                "/static/**",

                                //route access
                                "/",
                                "/login",
                                "/logout",

                                "/register",
                                "/register/save",
                                "/profile",
                                "/profile/save"

                        ).permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/db/**").access(allOf(hasAuthority("dbtest"), hasRole("Admin")))
                        .anyRequest().denyAll()
                );

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                    .authorizeRequests(authorize -> authorize
//                            .antMatchers("/login", "/register", "/clubs", "/css/**", "/js/**")
//                            .permitAll()
//                    )
//                    .formLogin(form -> form
//                            .loginPage("/login")
//                            .defaultSuccessUrl("/clubs")
//                            .loginProcessingUrl("/login")
//                            .failureUrl("/login?error=true")
//                            .permitAll()
//                    )
//                    .logout(logout -> logout
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                            .permitAll()
//                    );
//
//            return http.build();
//        }
//
//    }





}
