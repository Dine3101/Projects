package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.*;
import org.projects.springboot.ticketbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class TheatreRestController {

    @Autowired
    private TheatreService theatreService;
    @Autowired
    private ScreenService screenService;

    @Autowired
    private SessionService sessionService;

    @PostMapping("theatre")
    public void postTheatre(@RequestBody Theatre theatre){
        theatreService.addTheatre(theatre);
    }

    @PostMapping("theatre/{theatre-id}/screen")
    public void postTheatre(@PathVariable("theatre-id") int theatreId, @RequestBody Screen screen){
        Screen newScreen=screenService.saveScreen(screen);
        theatreService.addScreen(theatreId,newScreen);
    }

    @GetMapping("theatres")
    public List<Theatre> getTheatre(){
        return theatreService.getTheatres();
    }

    @GetMapping("theatre/{theatre-id}/screens")
    public List<Screen> getScreens(@PathVariable("theatre-id") int theatreId){
        List<Screen> screens= theatreService.getScreens(theatreId);
        return screens;
    }
    @PutMapping("theatre")
    public void updateTheatre(@RequestBody Theatre theatre){
        theatreService.saveTheatre(theatre);
    }
    @DeleteMapping("theatre/{theatre-id}")
    public void deleteTheatre(@PathVariable("theatre-id") int theatreId){
        theatreService.deleteTheatre(theatreId);
    }

    @DeleteMapping("theatre/{theatre-id}/screen")
    public void deleteTheatreScreen(@PathVariable("theatre-id") int theatreId,@RequestBody Screen screen){
        theatreService.dropScreen(theatreId,screen);
    }

    @DeleteMapping("theatre/{theatre-id}/screens")
    public void deleteTheatreScreens(@PathVariable("theatre-id") int theatreId){
        theatreService.dropScreens(theatreId);
    }
    

}
