package org.projects.springboot.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Component
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String language;
    @OneToMany(mappedBy = "movie")
    @JsonManagedReference(value="screen-movie")
    private List<Screen> screens;
}
