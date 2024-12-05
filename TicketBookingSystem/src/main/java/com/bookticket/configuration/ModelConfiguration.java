package com.bookticket.configuration;

import com.bookticket.model.*;
import com.bookticket.model.AppUser;
import com.bookticket.model.Role;
import org.projects.springboot.ticketbooking.model.*;
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
        theatre.setLocation("Sample Location");
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
    @Bean(name="Admin")
    public AppUser user1(){
        return new AppUser("admin","admin");
    }

    @Bean(name="Viewer")
    public AppUser user2(){
        return new AppUser("viewer","user");
    }

    @Bean(name="Distributor")
    public AppUser user3(){
        return new AppUser("distributor","user");
    }

    @Bean(name="Owner")
    public AppUser user4(){
        return new AppUser("owner","user");
    }

    @Bean
    public Role movieViewer(){
        Role role=new Role();
        role.setName("MOVIE_VIEWER");
        role.setPurpose("want to buy movie tickets");
        role.setAppUsers(new LinkedList<>());
        return role;
    }

    @Bean
    public Role movieDistributor(){
        Role role=new Role();
        role.setName("MOVIE_DISTRIBUTOR");
        role.setPurpose("want to distribute movies");
        role.setAppUsers(new LinkedList<>());
        return role;
    }

    @Bean
    public Role theatreOwner(){
        Role role=new Role();
        role.setName("THEATRE_OWNER");
        role.setPurpose("want to sell movie tickets");
        role.setAppUsers(new LinkedList<>());
        return role;
    }

    @Bean
    public Role admin(){
        Role role=new Role();
        role.setName("ADMIN");
        role.setPurpose("want to set up the application");
        role.setAppUsers(new LinkedList<>());
        return role;
    }
}
