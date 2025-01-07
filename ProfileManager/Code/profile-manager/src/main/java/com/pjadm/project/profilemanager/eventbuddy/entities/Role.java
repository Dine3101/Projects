package com.pjadm.project.profilemanager.eventbuddy.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name="ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column(name="ROLE_ID")
    int roleId;
    @Column(name="ROLE_NAME")
    String roleName;

}
