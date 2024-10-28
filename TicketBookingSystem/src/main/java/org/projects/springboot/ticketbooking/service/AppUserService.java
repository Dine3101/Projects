package org.projects.springboot.ticketbooking.service;

import jakarta.transaction.Transactional;
import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.model.Role;
import org.projects.springboot.ticketbooking.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ApplicationContext applicationContext;

    public AppUser findByUserId(String userId){
        return appUserRepository.findByUserId(userId);
    }

    private void saveUser(AppUser user){
        appUserRepository.save(user);
    }

    public void addUser(AppUser user){
        saveUser(user);
    }

    @Transactional
    public void addUser(AppUser user,String roleName){
        Role role=roleService.getRole(roleName);
        role.getAppUsers().add(user);
        user.setRole(role);
        saveUser(user);
    }
    public void init(AppUser user,String roleName){
        addUser(user);
        addUser(user,roleName);
    }
    public void initSample(){
        init((AppUser)applicationContext.getBean("Admin"),"ADMIN");
        init((AppUser)applicationContext.getBean("Viewer"),"MOVIE_VIEWER");
        init((AppUser)applicationContext.getBean("Distributor"),"MOVIE_DISTRIBUTOR");
        init((AppUser)applicationContext.getBean("Owner"),"THEATRE_OWNER");
    }

    public List<AppUser> getUsers(){
        return appUserRepository.findAll();
    }
}
