package org.projects.springboot.ticketbooking.service;

import org.projects.springboot.ticketbooking.model.Movie;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movie.setScreens(new ArrayList<>());
        movieRepository.save(movie);
    }

    public List<Movie> getMovies(){
        List<Movie> movies=movieRepository.findAll();
        return movies;
    }

    public Movie movie(int movieId){
        return movieRepository.findById(movieId).get();
    }

    public void deleteMovie(Movie movie){
        movieRepository.delete(movie);
    }

    public void addScreen(int movieId, Screen screen){
        Movie movie=movieRepository.findById(movieId).get();
        if(movie==null) return;
        screen.setMovie(movie);
        movie.getScreens().add(screen);
        movieRepository.save(movie);
    }
}
