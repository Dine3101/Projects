package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping("user/register")
    public void postUser(@RequestBody AppUser user){
        userService.addUser(user);
    }
}
