package org.projects.springboot.ticketbooking.service;

import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("demoUser")
    private AppUser demoUser;
    public AppUser findByUserId(String userId){
        return userRepository.findByUserId(userId);
    }

    private void saveUser(AppUser user){
        userRepository.save(user);
    }

    public void addUser(AppUser user){
        saveUser(user);
    }
    public void initSample(){
        saveUser(demoUser);
    }
}
