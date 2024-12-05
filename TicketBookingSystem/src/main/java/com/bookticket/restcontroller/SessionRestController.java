package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.Session;
import org.projects.springboot.ticketbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class SessionRestController {

    @Autowired
    private TheatreService theatreService;
    @Autowired
    private ScreenService screenService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("session/{session-id}")
    public Session getSession(@PathVariable("session-id") int sessionId){
        return sessionService.getSession(sessionId);
    }

    @GetMapping("sessions")
    public List<Session> getSessions(){
        return sessionService.getAllSessions();
    }
    @DeleteMapping("session/{session-id}")
    public void deleteSession(@PathVariable("session-id") int sessionId){
        sessionService.dropSession(sessionId);
    }


}
