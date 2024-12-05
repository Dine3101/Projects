package com.bookticket.restcontroller;

import com.bookticket.model.Session;
import com.bookticket.service.ScreenService;
import com.bookticket.model.Screen;
import com.bookticket.service.SessionService;
import com.bookticket.service.TheatreService;
import org.projects.springboot.ticketbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ScreenRestController {

    @Autowired
    private TheatreService theatreService;
    @Autowired
    private ScreenService screenService;

    @Autowired
    private SessionService sessionService;
    @PostMapping("screen")
    public void postSeat(@RequestBody Screen screen){
        screenService.addScreen(screen);
    }

    @PostMapping("screen/{screen-id}/session")
    public ResponseEntity postSession(@PathVariable("screen-id") int screenId, @RequestBody Session session){
        try {
            sessionService.addSession(session);
            screenService.addSession(screenId,sessionService.getSession(session.getId()));
            return ResponseEntity.ok("Session is added successfully");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("screens")
    public List<Screen> getScreen(){
        return screenService.getScreens();
    }

    @GetMapping("screen/{screen-id}")
    public Screen getScreen(@PathVariable("screen-id") int screenId){
        return screenService.getScreen(screenId);
    }


    @DeleteMapping("screen/{screen-id}")
    public void deleteScreen(@PathVariable("screen-id") int screenId){
        screenService.dropScreen(screenId);
    }

    @DeleteMapping("screen/{screen-id}/session")
    public void deleteSession(@PathVariable("screen-id") int screenId,@RequestBody Session session){
        screenService.deleteSession(screenId,session.getId());
    }


}
