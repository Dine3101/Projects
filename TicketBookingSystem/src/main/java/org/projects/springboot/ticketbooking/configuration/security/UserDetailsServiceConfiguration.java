package org.projects.springboot.ticketbooking.configuration.security;


import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceConfiguration implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user=userService.findByUserId(username);
        if(user==null){
            throw new UsernameNotFoundException("Unauthorized Sign In");
        }
        return new UserPrincipal(user);
    }
}
