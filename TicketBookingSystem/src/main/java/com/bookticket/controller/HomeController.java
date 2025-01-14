package com.bookticket.controller;


import com.bookticket.configuration.security.UserPrincipal;
import com.bookticket.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private AppUser user;

    @RequestMapping("/")
    public ModelAndView homePage(){
        ModelAndView mv=new ModelAndView("home_view");
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal() instanceof UserPrincipal){
            UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal();
            mv.addObject("user",userPrincipal.getUser());
        }else{
            mv.addObject("user",null);
        }
        return mv;
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

    @RequestMapping("/server-error")
    public ModelAndView displayError(@RequestParam("message") String message){
        ModelAndView mv=new ModelAndView("error_view");
        mv.addObject("message",message);
        return mv;
    }
}
