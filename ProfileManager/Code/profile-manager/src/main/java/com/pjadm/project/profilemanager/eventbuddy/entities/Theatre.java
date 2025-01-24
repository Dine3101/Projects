package com.pjadm.project.profilemanager.eventbuddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/** Entity class for THEATRE table **/
@Component
@Entity
@Table(name="THEATRE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="THEATRE_ID")
    private int theatreId;

    @Column(name="NAME",nullable = false)
    private String name;

    @Column(name="LOCATION")
    private String location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="OWNER_ID")
    private AppUser owner;

    public void setProfile(Theatre theatre){
        this.name=theatre.getName();
        this.location=theatre.getLocation();
    }
}
