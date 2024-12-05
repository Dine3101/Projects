package com.bookticket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Component
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String screenName;
    private int seatCount;
    private int rows;
    private int cols;
    private long price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Theatre theatre;
    @OneToMany(mappedBy="screen",cascade = CascadeType.ALL)
    @JsonManagedReference(value="screen-session")
    private List<Session> sessions;
    @ManyToOne(fetch=FetchType.EAGER)
    @JsonBackReference(value="screen-movie")
    private Movie movie;
}
