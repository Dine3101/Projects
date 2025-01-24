package com.pjadm.project.profilemanager.eventbuddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/** Entity class for WATCHLIST table **/
@Component
@Entity
@Table(name="WATCHLIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MOVIE_ID")
    public int movieId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="MOVIE_NAME")
    public Movie movie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="VIEWER_ID")
    public AppUser viewer;
}
