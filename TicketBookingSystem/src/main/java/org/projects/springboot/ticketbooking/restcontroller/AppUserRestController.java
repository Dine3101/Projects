package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class AppUserRestController {
    @Autowired
    private AppUserService appUserService;

    @PostMapping("user/register")
    public void postUser(@RequestBody AppUser user,@RequestParam("role-id") int roleId){
        appUserService.addUser(user);
        System.out.println(roleId);
    }

    @GetMapping("users")
    public List<AppUser> getUsers(){
        return appUserService.getUsers();
    }
}
