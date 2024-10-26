package org.projects.springboot.ticketbooking.controller;


import org.projects.springboot.ticketbooking.model.AppUser;
import org.projects.springboot.ticketbooking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private AppUser user;

    @RequestMapping("/")
    public String homePage(){
        return "home_view";
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView mv=new ModelAndView("register_view");
        mv.addObject("appUser",user);
        return mv;
    }

    @GetMapping("/login-form")
    public String login(){
        return "login-view";
    }
}
