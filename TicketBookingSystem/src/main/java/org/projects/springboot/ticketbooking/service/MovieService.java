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

    public Movie getMovie(int movieId){
        return movieRepository.findById(movieId).get();
    }
    public List<Movie> getMovies(){
        List<Movie> movies=movieRepository.findAll();
        return movies;
    }

    public void deleteMovie(Movie movie){
        movieRepository.delete(movie);
    }

    public void deleteMovie(int movieId){
        Movie movie=getMovie(movieId);
        deleteMovie(movie);
    }

    public void addScreen(int movieId, Screen screen){
        Movie movie=getMovie(movieId);
        if(movie==null) return;
        screen.setMovie(movie);
        movie.getScreens().add(screen);
        movieRepository.save(movie);
    }
}
