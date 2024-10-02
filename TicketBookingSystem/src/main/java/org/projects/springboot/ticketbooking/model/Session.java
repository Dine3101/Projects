package org.projects.springboot.ticketbooking.model;

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
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sessionName;
    private int totalSeatCount;
    private int availableSeatCount;
    private long price;
    private int rows;
    private int cols;
    private String startTime;
    private String endTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value="screen-session")
    private Screen screen;
}
