package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import com.pjadm.project.profilemanager.eventbuddy.models.request.role.UpdateRoleRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.role.RoleResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleResponseBody roleResponseBody;

    @GetMapping("all")
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }

    @PostMapping("add")
    public RoleResponseBody addRole(@RequestBody Role role){
        roleService.addRole(role,roleResponseBody);
        return roleResponseBody;
    }

    @PostMapping("update")
    public RoleResponseBody updateRole(@RequestBody UpdateRoleRequestBody updateRoleRequestBody){
        roleService.updateRole(updateRoleRequestBody,roleResponseBody);
        return roleResponseBody;
    }

    @PostMapping("delete")
    public RoleResponseBody deleteRole(@RequestBody Role role){
        roleService.deleteRole(role,roleResponseBody);
        return roleResponseBody;
    }
}
