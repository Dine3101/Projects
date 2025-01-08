package com.pjadm.project.profilemanager.eventbuddy.models.request.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequestBody {
    String purpose;
    String oldRoleName;
    String newRoleName;
}
