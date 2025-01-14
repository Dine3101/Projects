package com.pjadm.project.profilemanager.eventbuddy.models.request.AppUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** Rest API request body Component for AppUser Entity-related queries **/
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAppUserRequestBody {
    String purpose;
    String emailId;
    String name;
    String phoneNumber;
    String roleName;
}
