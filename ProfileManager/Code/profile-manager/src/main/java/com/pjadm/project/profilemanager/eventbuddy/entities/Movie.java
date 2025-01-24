package com.pjadm.project.profilemanager.eventbuddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/** Entity class for MOVIE table **/
@Component
@Entity
@Table(name="MOVIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @Column(name="MOVIE_NAME")
    private String movieName;

    @Column(name="LANGUAGE",nullable = false)
    private String language;

    @Column(name="THEME")
    private String theme;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="DISTRIBUTOR_ID",nullable = false)
    private AppUser distributor;

    public void setProfile(Movie movie){
        this.language=movie.getLanguage();
        this.theme=movie.getTheme();
    }
}
