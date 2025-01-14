package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import com.pjadm.project.profilemanager.eventbuddy.models.request.Role.UpdateRoleRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/** Rest API controller for Role Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("get/all")
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("get")
    public ResponseBody<Role> getRole(@RequestBody Role role){
        return roleService.getRole(role);
    }


    @PostMapping("add")
    public ResponseBody<Role> addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @PostMapping("update")
    public ResponseBody<Role> updateRole(@RequestBody UpdateRoleRequestBody updateRoleRequestBody){
        return roleService.updateRole(updateRoleRequestBody);
    }

    @PostMapping("delete")
    public ResponseBody<Role> deleteRole(@RequestBody Role role){
        return roleService.deleteRole(role);
    }
}
