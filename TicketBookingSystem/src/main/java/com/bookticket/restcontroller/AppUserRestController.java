package com.bookticket.restcontroller;

import com.bookticket.model.AppUser;
import com.bookticket.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/")
public class AppUserRestController {
    @Autowired
    private AppUserService appUserService;

    @PostMapping("register/{role-name}")
    public void postUser(@RequestBody AppUser user,@PathVariable("role-name") String roleName){
        appUserService.addRole(user.getUserId(),roleName);
    }
    @GetMapping("users")
    public List<AppUser> getUsers(){
        return appUserService.getUsers();
    }
}
