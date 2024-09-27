package org.projects.springboot.ticketbooking.configuration;

import org.projects.springboot.ticketbooking.model.Movie;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.model.Theatre;
import org.projects.springboot.ticketbooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

@Configuration
public class ModelConfiguration {

    @Bean
    public Movie sampleMovie(){
        Movie movie=new Movie();
        movie.setId(1);
        movie.setName("Movie not added yet");
        movie.setScreens(new LinkedList<>());
        return movie;
    }

    @Bean
    public Movie sampleMovieDisplay(){
        Movie movie=new Movie();
        movie.setId(2);
        movie.setName("Sample Movie");
        return movie;
    }
    @Bean
    public Theatre sampleTheatre(){
        Theatre theatre=new Theatre();
        theatre.setId(1);
        theatre.setName("Sample Theatre");
        theatre.setScreens(new LinkedList<>());
        return theatre;
    }

    @Bean
    public Screen sampleScreen(){
        Screen screen=new Screen();
        screen.setId(1);
        screen.setScreenName("Sample Screen");
        screen.setSeatCount(20);
        screen.setPrice(20);
        return screen;
    }
}
