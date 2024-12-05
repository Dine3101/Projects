package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.model.Role;
import org.projects.springboot.ticketbooking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/")
public class RoleRestController {
    @Autowired
    private RoleService roleService;

    @PostMapping("role/add")
    public void addRole(Role role){
        roleService.addRole(role);
    }

    @GetMapping("roles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }
}
