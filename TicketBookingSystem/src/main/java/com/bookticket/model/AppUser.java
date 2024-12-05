package com.bookticket.model.entity;

import com.bookticket.model.relation.AppUserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String userId;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference(value="user-role")
    private Role role;

    public AppUser (String userId,String password){
        this.userId=userId;
        this.password=password;
    }

}
