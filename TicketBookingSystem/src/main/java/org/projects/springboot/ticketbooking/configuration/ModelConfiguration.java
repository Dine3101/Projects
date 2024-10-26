package org.projects.springboot.ticketbooking.configuration;

import org.projects.springboot.ticketbooking.model.*;
import org.projects.springboot.ticketbooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
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
        screen.setRows(5);
        screen.setCols(5);
        return screen;
    }

    @Bean
    public AppUser user(){
        return new AppUser();
    }
    @Bean
    public AppUser demoUser(){
        AppUser user =new AppUser();
        user.setId(1);
        user.setUserId("demo123");
        user.setPassword("demo123");
        return user;
    }

    @Bean
    public Role movieViewer(){
        Role role=new Role();
        role.setName("MOVIE_VIEWER");
        role.setPurpose("buy movie tickets");
        role.setAppUsers(new LinkedList<>());
        return role;
    }

    @Bean
    public Role movieDistributor(){
        Role role=new Role();
        role.setName("MOVIE_DISTRIBUTOR");
        role.setPurpose("distribute movies");
        role.setAppUsers(new LinkedList<>());
        return role;
    }

    @Bean
    public Role theatreOwner(){
        Role role=new Role();
        role.setName("THEATRE_OWNER");
        role.setPurpose("sell movie tickets");
        role.setAppUsers(new LinkedList<>());
        return role;
    }

    @Bean
    public Role admin(){
        Role role=new Role();
        role.setName("ADMIN");
        role.setPurpose("admin");
        role.setAppUsers(new LinkedList<>());
        return role;
    }
}
