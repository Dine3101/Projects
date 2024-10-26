package org.projects.springboot.ticketbooking.service;

import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    @Qualifier("demoUser")
    private AppUser demoUser;
    public AppUser findByUserId(String userId){
        return appUserRepository.findByUserId(userId);
    }

    private void saveUser(AppUser user){
        appUserRepository.save(user);
    }

    public void addUser(AppUser user){
        saveUser(user);
    }
    public void initSample(){
        demoUser.setRole(roleService.getRole("ADMIN"));
        saveUser(demoUser);
    }

    public List<AppUser> getUsers(){
        return appUserRepository.findAll();
    }
}
