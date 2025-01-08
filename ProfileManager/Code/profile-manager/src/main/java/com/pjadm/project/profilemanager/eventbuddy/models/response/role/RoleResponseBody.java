package com.pjadm.project.profilemanager.eventbuddy.models.response.role;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseBody {
    String status;
    String message;
    Role role;
    public void setBody(String status,String message,Role role){
        this.status=status;
        this.message=message;
        this.role=role;
    }
}
