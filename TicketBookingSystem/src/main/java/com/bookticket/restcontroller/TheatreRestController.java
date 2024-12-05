package com.bookticket.restcontroller;

import com.bookticket.model.Screen;
import com.bookticket.model.Theatre;
import com.bookticket.service.MovieService;
import com.bookticket.service.ScreenService;
import com.bookticket.service.SessionService;
import com.bookticket.service.TheatreService;
import jakarta.servlet.http.HttpServletRequest;
import org.projects.springboot.ticketbooking.model.*;
import org.projects.springboot.ticketbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
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
    private MovieService movieService;

    @Autowired
    private SessionService sessionService;

    @PostMapping("theatre")
    public ResponseEntity postTheatre(@RequestBody Theatre theatre){
        try {
            theatreService.addTheatre(theatre);
            return ResponseEntity.ok("Theatre Added Successfully");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("theatre/{theatre-id}/screen")
    public void postTheatre(@PathVariable("theatre-id") int theatreId, @RequestBody Screen screen){
        screen.setMovie(movieService.getSample());
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

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
