package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.model.Session;
import org.projects.springboot.ticketbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void postSession(@PathVariable("screen-id") int screenId,@RequestBody Session session){
        sessionService.addSession(session);
        screenService.addSession(screenId,sessionService.getSession(session.getId()));
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
