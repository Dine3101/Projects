package org.projects.springboot.ticketbooking.configuration;

import org.projects.springboot.ticketbooking.service.MovieService;
import org.projects.springboot.ticketbooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunner implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    public void run(String[] args){
        theatreService.initSample();
        movieService.initSample();
    }
}
