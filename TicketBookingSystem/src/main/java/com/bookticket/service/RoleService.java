package com.bookticket.service;

import com.bookticket.repository.RoleRepository;
import com.bookticket.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private Role admin,movieViewer,movieDistributor,theatreOwner;

    public void addRole(Role role){
        roleRepository.save(role);
    }
    public void init(){
        addRole(admin);
        addRole(movieViewer);
        addRole(movieDistributor);
        addRole(theatreOwner);
    }
    public Role getRole(String name){
        return roleRepository.findByName(name);
    }


    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}
