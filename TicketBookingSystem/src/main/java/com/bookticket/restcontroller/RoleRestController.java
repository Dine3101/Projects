package com.bookticket.restcontroller;

import com.bookticket.service.RoleService;
import com.bookticket.model.Role;
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
