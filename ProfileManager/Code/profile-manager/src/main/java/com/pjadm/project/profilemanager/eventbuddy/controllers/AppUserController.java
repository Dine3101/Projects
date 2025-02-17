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

    @GetMapping("/{email-id}")
    public ResponseBody<AppUser> getAppUser(@PathVariable("email-id") String emailId){
        return appUserService.getAppUser(emailId);
    }

    @PostMapping("")
    public ResponseBody<AppUser> addAppUser(@RequestBody AppUser appUser){
        return appUserService.addAppUser(appUser);
    }

    @DeleteMapping("/{email-id}")
    public ResponseBody<AppUser> deleteAppUser(@PathVariable("email-id") String emailId){
        return appUserService.deleteAppUser(emailId);
    }

    @PatchMapping("")
    public ResponseBody<AppUser> updateAppUser(@RequestBody UpdateAppUserRequestBody updateAppUserRequestBody){
        return appUserService.updateAppUser(updateAppUserRequestBody);
    }





}
