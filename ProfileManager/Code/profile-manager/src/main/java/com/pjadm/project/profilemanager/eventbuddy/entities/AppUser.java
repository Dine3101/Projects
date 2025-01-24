package com.pjadm.project.profilemanager.eventbuddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** Entity class for APPUSER table **/
@Component
@Entity
@Table(name="APPUSER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @Column(name="EMAIL_ID")
    private String emailId;

    @Column(name="NAME",nullable = false)
    private String name;

    @Column(name="PHONE_NUMBER",nullable = false)
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    public void setProfile(String name,String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }
}
