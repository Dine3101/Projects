package org.projects.springboot.ticketbooking.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(customizer->customizer.disable())
                .authorizeHttpRequests(request->request
                        .requestMatchers("/","/css/**","/js/**","/fonts/**","/images/**","/login","/logout","/register")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(form->form
                        .loginPage("/login-form")
                        .usernameParameter("user-id")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/",true)
                        .permitAll())
                .logout(logout->logout
                        .permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }
}
