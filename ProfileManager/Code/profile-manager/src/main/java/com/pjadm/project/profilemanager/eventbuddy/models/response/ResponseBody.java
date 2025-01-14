package com.pjadm.project.profilemanager.eventbuddy.models.response;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** Common Response Body for Rest API controllers **/
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody<T> {
    String status;
    String message;
    T data;
    public void setBody(String status,String message,T data){
        this.status=status;
        this.message=message;
        this.data=data;
    }
}
