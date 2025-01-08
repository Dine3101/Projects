package com.pjadm.project.profilemanager.eventbuddy.services;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import com.pjadm.project.profilemanager.eventbuddy.models.request.role.UpdateRoleRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.role.RoleResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAllRoles();
    }


    public void addRole(Role role,RoleResponseBody roleResponseBody){
        try {
            roleRepository.addRole(role);
            roleResponseBody.setBody("SUCCESS","Successfully added the Role",role);
        }catch (Exception e){
            roleResponseBody.setBody("FAILURE","Error while adding the Role..."+e.getMessage(),role);
        }
    }

    public void updateRole(UpdateRoleRequestBody updateRoleRequestBody,RoleResponseBody roleResponseBody){
        try{
            if(updateRoleRequestBody.getPurpose().equals("Role Name Change")){
                Role updatedRole=roleRepository.updateRole(updateRoleRequestBody);
                roleResponseBody.setBody("SUCCESS","Successfully updated the Role",updatedRole);
            }else{
                roleResponseBody.setBody("FAILURE","Invalid Request for Role update",null);
            }
        }catch (Exception e){
            roleResponseBody.setBody("FAILURE","Error while updating the Role..."+e.getMessage(),null);
        }

    }

    public void deleteRole(Role role,RoleResponseBody roleResponseBody){
        try{
            roleRepository.deleteRole(role);
            roleResponseBody.setBody("SUCCESS","Successfully deleted the Role", role);
        }catch(Exception e){
            roleResponseBody.setBody("FAILURE","Error while deleting the Role..."+e.getMessage(),role);
        }
    }
}
