package com.bookticket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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

    public void book(){
        this.availableSeatCount--;
    }

    public boolean isFull(){
        return this.availableSeatCount==0;
    }
}
