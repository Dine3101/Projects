package com.bookticket.service;

import com.bookticket.model.AppUser;
import com.bookticket.model.Role;
import com.bookticket.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    private void saveUser(AppUser user){
        appUserRepository.save(user);
    }
    public void addUser(AppUser user){
        saveUser(user);
    }
    private AppUser findByUserId(String userId){
        return appUserRepository.findByUserId(userId);
    }

    public AppUser getUser(String userId){
        return findByUserId(userId);
    }

    @Transactional
    private void addRole(AppUser user,String roleName){
        Role role=roleService.getRole(roleName);
        role.getAppUsers().add(user);
        user.setRole(role);
        saveUser(user);
    }

    public void addRole(String userId,String roleName){
        addRole(findByUserId(userId),roleName);
    }
    private void initUser(AppUser user,String roleName){
        addUser(user);
        addRole(user,roleName);
    }
    public void init(){
        initUser((AppUser)applicationContext.getBean("Admin"),"ADMIN");
        initUser((AppUser)applicationContext.getBean("Viewer"),"MOVIE_VIEWER");
        initUser((AppUser)applicationContext.getBean("Distributor"),"MOVIE_DISTRIBUTOR");
        initUser((AppUser)applicationContext.getBean("Owner"),"THEATRE_OWNER");
    }

    public List<AppUser> getUsers(){
        return appUserRepository.findAll();
    }
}
