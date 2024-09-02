package org.projects.springboot.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    private List<String> actorsList;
//    private List<String> languagesList;
//    private String director;
//    private String producer;
//    private String releaseDate;
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    @JsonManagedReference(value="movie-screen")
    private List<Screen> screens;
}
