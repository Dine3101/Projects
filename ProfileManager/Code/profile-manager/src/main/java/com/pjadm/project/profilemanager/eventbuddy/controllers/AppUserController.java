package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.AppUser;
import com.pjadm.project.profilemanager.eventbuddy.models.request.appuser.UpdateAppUserRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Rest API controller for AppUser Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/appuser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/all")
    public List<AppUser> getAppUsers(){
        return appUserService.getAllAppUsers();
    }

    @GetMapping("")
    public ResponseBody<AppUser> getAppUser(@RequestBody AppUser appUser){
        return appUserService.getAppUser(appUser);
    }

    @PostMapping("")
    public ResponseBody<AppUser> addAppUser(@RequestBody AppUser appUser){
        return appUserService.addAppUser(appUser);
    }

    @DeleteMapping("delete")
    public ResponseBody<AppUser> deleteAppUser(@RequestBody AppUser appUser){
        return appUserService.deleteAppUser(appUser);
    }

    @PatchMapping("")
    public ResponseBody<AppUser> updateAppUser(@RequestBody UpdateAppUserRequestBody updateAppUserRequestBody){
        return appUserService.updateAppUser(updateAppUserRequestBody);
    }





}
