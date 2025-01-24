package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import com.pjadm.project.profilemanager.eventbuddy.models.request.role.UpdateRoleRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/** Rest API controller for Role Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{role-name}")
    public ResponseBody<Role> getRole(@PathVariable("role-name") String roleName){
        return roleService.getRole(roleName);
    }


    @PostMapping("")
    public ResponseBody<Role> addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @PatchMapping("")
    public ResponseBody<Role> updateRole(@RequestBody UpdateRoleRequestBody updateRoleRequestBody){
        return roleService.updateRole(updateRoleRequestBody);
    }

    @DeleteMapping("/{role-name}")
    public ResponseBody<Role> deleteRole(@PathVariable("role-name") String roleName){
        return roleService.deleteRole(roleName);
    }
}
