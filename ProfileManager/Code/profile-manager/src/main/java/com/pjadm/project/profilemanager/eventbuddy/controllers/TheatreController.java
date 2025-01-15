package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.Theatre;
import com.pjadm.project.profilemanager.eventbuddy.models.request.Theatre.UpdateTheatreRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.TheatreService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Rest API controller for Movie Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/theatre/")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("add")
    public ResponseBody<Theatre> addTheatre(@RequestBody Theatre theatre){
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("get")
    public ResponseBody<Theatre> getTheatre(@RequestBody Theatre theatre){
        return theatreService.getTheatre(theatre);
    }

    @GetMapping("get/all")
    public List<Theatre> getTheatres(){
        return theatreService.getTheatres();
    }

    @PostMapping("delete")
    public ResponseBody<Theatre> deleteTheatre(@RequestBody Theatre theatre){
        return theatreService.deleteTheatre(theatre);
    }

    @PostMapping("update")
    public ResponseBody<Theatre> updateTheatre(@RequestBody UpdateTheatreRequestBody updateTheatreRequestBody){
        return theatreService.updateTheatre(updateTheatreRequestBody);
    }
}

