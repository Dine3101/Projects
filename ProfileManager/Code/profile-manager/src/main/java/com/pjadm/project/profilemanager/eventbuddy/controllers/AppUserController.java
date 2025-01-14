package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.AppUser;
import com.pjadm.project.profilemanager.eventbuddy.models.request.AppUser.UpdateAppUserRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Rest API controller for AppUser Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/appuser/")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("get/all")
    public List<AppUser> getAppUsers(){
        return appUserService.getAllAppUsers();
    }

    @GetMapping("get")
    public ResponseBody<AppUser> getAppUser(@RequestBody AppUser appUser){
        return appUserService.getAppUser(appUser);
    }

    @PostMapping("add")
    public ResponseBody<AppUser> addAppUser(@RequestBody AppUser appUser){
        return appUserService.addAppUser(appUser);
    }

    @PostMapping("delete")
    public ResponseBody<AppUser> deleteAppUser(@RequestBody AppUser appUser){
        return appUserService.deleteAppUser(appUser);
    }

    @PostMapping("update")
    public ResponseBody<AppUser> updateAppUser(@RequestBody UpdateAppUserRequestBody updateAppUserRequestBody){
        return appUserService.updateAppUser(updateAppUserRequestBody);
    }





}
