package org.projects.springboot.ticketbooking.configuration;

import org.projects.springboot.ticketbooking.model.Movie;
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
}
