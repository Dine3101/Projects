package org.projects.springboot.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.StyleContext;
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
    private long price;
    @ManyToOne
    @JsonBackReference
    private Theatre theatre;
    @OneToMany(mappedBy="screen",cascade = CascadeType.ALL)
    @JsonManagedReference(value="screen-session")
    private List<Session> sessions;
    @ManyToOne
    @JsonBackReference(value="movie-screen")
    private Movie movie;
}
