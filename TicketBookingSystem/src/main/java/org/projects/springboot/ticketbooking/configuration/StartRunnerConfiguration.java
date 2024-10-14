package org.projects.springboot.ticketbooking.configuration;

import org.projects.springboot.ticketbooking.service.MovieService;
import org.projects.springboot.ticketbooking.service.ScreenService;
import org.projects.springboot.ticketbooking.service.TheatreService;
import org.projects.springboot.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunnerConfiguration implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private ScreenService screenService;

    @Autowired
    private UserService userService;

    public void run(String[] args){
        screenService.initSample();
        theatreService.initSample();
        theatreService.addScreen(1,1);
        movieService.initSample();
        movieService.addScreen(1,1);
        userService.initSample();
    }
}
