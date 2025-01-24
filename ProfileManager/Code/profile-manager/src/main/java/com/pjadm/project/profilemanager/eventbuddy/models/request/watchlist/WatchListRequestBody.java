package com.pjadm.project.profilemanager.eventbuddy.models.request.watchlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/** Rest API request body Component for Watchlist Entity-related queries **/

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchListRequestBody {
    private String viewerId;
    private String movieName;
}
