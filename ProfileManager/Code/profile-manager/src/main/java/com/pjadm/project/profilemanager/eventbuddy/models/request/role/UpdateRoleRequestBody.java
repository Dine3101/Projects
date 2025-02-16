package com.pjadm.project.profilemanager.eventbuddy.models.request.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


/** Rest API request body Component for Role Entity-related queries **/
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequestBody {
    String purpose;
    String roleName;
    String newRoleName;
}
