package org.projects.springboot.ticketbooking.service;

import org.projects.springboot.ticketbooking.model.Role;
import org.projects.springboot.ticketbooking.repository.RoleRepository;
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
        roleRepository.save(admin);
        roleRepository.save(movieViewer);
        roleRepository.save(movieDistributor);
        roleRepository.save(theatreOwner);
    }
    public Role getRole(String name){
        return roleRepository.findByName(name);
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}
