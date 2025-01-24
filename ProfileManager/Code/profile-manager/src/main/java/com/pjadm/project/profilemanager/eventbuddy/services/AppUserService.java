package com.pjadm.project.profilemanager.eventbuddy.services;

import com.pjadm.project.profilemanager.eventbuddy.entities.AppUser;
import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import com.pjadm.project.profilemanager.eventbuddy.models.request.appuser.UpdateAppUserRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.repositories.AppUserRepository;
import com.pjadm.project.profilemanager.eventbuddy.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service layer for AppUser Entity-related Business logic implementation **/
@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUser appUser;

    @Autowired
    private ResponseBody<AppUser> responseBody;

    @Autowired
    private RoleRepository roleRepository;

    public List<AppUser> getAllAppUsers(){
        return appUserRepository.findAll();
    }
    public ResponseBody<AppUser> getAppUser(AppUser appUser){
        try{
            appUser=appUserRepository.find(appUser.getEmailId());
            responseBody.setBody("SUCCESS","Successfully fetched AppUser",appUser);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while fetching AppUser..."+e.getMessage(),appUser);
        }
        return responseBody;
    }
    public ResponseBody<AppUser> addAppUser(AppUser appUser){
        try{
            appUserRepository.add(appUser);
            responseBody.setBody("SUCCESS","Successfully added AppUser",appUser);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while adding AppUser..."+e.getMessage(),appUser);
        }
        return responseBody;
    }
    public ResponseBody<AppUser> deleteAppUser(AppUser appUser){
        try{
            appUser=appUserRepository.delete(appUser.getEmailId());
            responseBody.setBody("SUCCESS","Successfully deleted AppUser",appUser);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while deleting AppUser..."+e.getMessage(),appUser);
        }
        return responseBody;
    }

    public ResponseBody<AppUser> updateAppUser(UpdateAppUserRequestBody updateAppUserRequestBody){
        try{
            switch(updateAppUserRequestBody.getPurpose()){
                case "Profile":
                    appUser.setProfile(updateAppUserRequestBody.getName(),updateAppUserRequestBody.getPhoneNumber());
                    appUser=appUserRepository.update(updateAppUserRequestBody.getEmailId(),appUser);
                    responseBody.setBody("SUCCESS","Successfully Updated AppUser",appUser);
                    break;
                case "Role":
                    Role role=roleRepository.find(updateAppUserRequestBody.getRoleName());
                    appUser=appUserRepository.update(updateAppUserRequestBody.getEmailId(),role);
                    responseBody.setBody("SUCCESS","Successfully Updated AppUser",appUser);
                    break;
                default:
                    responseBody.setBody("FAILURE","Invalid Purpose",null);
            }
            return responseBody;
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while updating AppUser..."+e.getMessage(),null);
        }
        return responseBody;
    }
}
