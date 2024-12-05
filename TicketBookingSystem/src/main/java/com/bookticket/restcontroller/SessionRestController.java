package com.bookticket.restcontroller;

import com.bookticket.model.Session;
import com.bookticket.service.ScreenService;
import com.bookticket.service.SessionService;
import com.bookticket.service.TheatreService;
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
