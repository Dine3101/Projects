package org.projects.springboot.ticketbooking.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


import java.util.LinkedList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Component
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String location;
    private String ownerName;
    @OneToMany(mappedBy="theatre",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Screen> screens=new LinkedList<>();
}
