package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.Theatre;
import com.pjadm.project.profilemanager.eventbuddy.models.request.theatre.UpdateTheatreRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Rest API controller for Theatre Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("")
    public ResponseBody<Theatre> addTheatre(@RequestBody Theatre theatre){
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("")
    public ResponseBody<Theatre> getTheatre(@RequestBody Theatre theatre){
        return theatreService.getTheatre(theatre);
    }

    @GetMapping("/all")
    public List<Theatre> getTheatres(){
        return theatreService.getTheatres();
    }

    @DeleteMapping("")
    public ResponseBody<Theatre> deleteTheatre(@RequestBody Theatre theatre){
        return theatreService.deleteTheatre(theatre);
    }

    @PatchMapping("")
    public ResponseBody<Theatre> updateTheatre(@RequestBody UpdateTheatreRequestBody updateTheatreRequestBody){
        return theatreService.updateTheatre(updateTheatreRequestBody);
    }
}

