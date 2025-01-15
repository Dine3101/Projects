package com.pjadm.project.profilemanager.eventbuddy.models.request.Theatre;

import com.pjadm.project.profilemanager.eventbuddy.entities.Theatre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/** Rest API request body Component for Role Entity-related queries **/
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTheatreRequestBody {
    String purpose;
    Theatre theatre;
}
