package org.projects.springboot.ticketbooking.controller;


import jakarta.servlet.http.HttpSession;
import org.projects.springboot.ticketbooking.Application;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.model.Session;
import org.projects.springboot.ticketbooking.model.Theatre;
import org.projects.springboot.ticketbooking.service.ScreenService;
import org.projects.springboot.ticketbooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @Autowired
    ScreenService screenService;

    @Autowired
    private Theatre theatre;

    @Autowired
    private Screen screen;

    @Autowired
    private Session session;

    @RequestMapping("theatre")
    public ModelAndView getTheatres() {
        List<Theatre> theatres = theatreService.getTheatres();
        ModelAndView mv = new ModelAndView("theatre_view");
        mv.addObject("theatres", theatres);
        return mv;
    }

    @RequestMapping("theatre/add")
    public ModelAndView addTheatreForm() {
        ModelAndView mv = new ModelAndView("theatre_add-form");
        mv.addObject(theatre);
        return mv;
    }

    @RequestMapping("theatre/{theatre-id}/screen/view")
    public ModelAndView getTheatreScreenList(@PathVariable("theatre-id") int theatreId) {
        List<Screen> screens = theatreService.getScreens(theatreId);
        Theatre theatre=theatreService.getTheatre(theatreId);
        ModelAndView mv = new ModelAndView("screen_view");
        mv.addObject("screens", screens);
        mv.addObject("theatreId", theatreId);
        return mv;
    }

    @RequestMapping("theatre/{theatre-id}/screen/add")
    public ModelAndView getTheatreScreenAddForm(@PathVariable("theatre-id") int theatreId) {
        ModelAndView mv = new ModelAndView("screen_add-form");
        mv.addObject("screen", screen);
        mv.addObject("theatreId", theatreId);
        return mv;
    }

    @RequestMapping("screen/{screen-id}/session/view")
    public ModelAndView getScreenSessionList(@PathVariable("screen-id") int screenId) {
        List<Session> sessions = screenService.getSessions(screenId);
        Screen screen=screenService.getScreen(screenId);
        Theatre theatre=screen.getTheatre();
        ModelAndView mv = new ModelAndView("session_view");
        mv.addObject("screenId", screenId);
        mv.addObject("screen",screen);
        mv.addObject("sessions", sessions);
        return mv;
    }

    @RequestMapping("screen/{screen-id}/session/add")
    public ModelAndView getScreenSessionAddForm(@PathVariable("screen-id") int screenId){
        ModelAndView mv=new ModelAndView("session_add-form");
        mv.addObject("session",session);
        mv.addObject("screenId",screenId);
        return mv;
    }
}
