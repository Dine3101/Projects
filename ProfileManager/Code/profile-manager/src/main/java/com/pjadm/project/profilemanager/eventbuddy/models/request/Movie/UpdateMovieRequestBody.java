package com.pjadm.project.profilemanager.eventbuddy.models.request.Movie;

import com.pjadm.project.profilemanager.eventbuddy.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


/** Rest API request body Component for Movie Entity-related queries **/
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieRequestBody {
    String purpose;
    Movie movie;
}
