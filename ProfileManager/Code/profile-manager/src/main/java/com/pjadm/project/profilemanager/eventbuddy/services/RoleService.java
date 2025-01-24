package com.pjadm.project.profilemanager.eventbuddy.services;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import com.pjadm.project.profilemanager.eventbuddy.models.request.role.UpdateRoleRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service layer for Role Entity-related Business logic implementation **/
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ResponseBody<Role> responseBody;
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public ResponseBody<Role> getRole(String roleName){
        try{
            Role role=roleRepository.find(roleName);
            responseBody.setBody("SUCCESS","Successfully fetched the Role",role);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while fetching the Role with role name: "+roleName+". Error: "+e.getMessage(),null);
        }
        return responseBody;
    }

    public ResponseBody<Role> addRole(Role role){
        try {
            roleRepository.add(role);
            responseBody.setBody("SUCCESS","Successfully added the Role",role);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while adding the Role: "+e.getMessage(),role);
        }
        return responseBody;
    }

    public ResponseBody<Role> updateRole(UpdateRoleRequestBody updateRoleRequestBody){
        try{
            if(updateRoleRequestBody.getPurpose().equals("RoleName")){
                Role updatedRole=roleRepository.updateRole(updateRoleRequestBody.getRoleName(), updateRoleRequestBody.getNewRoleName());
                responseBody.setBody("SUCCESS","Successfully updated the Role",updatedRole);
            }else{
                responseBody.setBody("FAILURE","Invalid Request for Role update.",null);
            }
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while updating the Role: "+e.getMessage(),null);
        }
        return responseBody;

    }

    public ResponseBody<Role> deleteRole(String roleName){
        try{
            Role role=roleRepository.delete(roleName);
            responseBody.setBody("SUCCESS","Successfully deleted the Role", role);
        }catch(Exception e){
            responseBody.setBody("FAILURE","Error while deleting the Role with role name: "+roleName+". Error: "+e.getMessage(),null);
        }
        return responseBody;
    }
}
