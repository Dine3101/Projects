package org.projects.springboot.ticketbooking.service;

import jakarta.transaction.Transactional;
import org.projects.springboot.ticketbooking.model.Movie;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenService screenService;

    public void addMovie(Movie movie){
        movie.setScreens(new LinkedList<>());
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
        deleteScreens(movieId);
        deleteMovie(movie);
    }

    @Transactional
    public void addScreen(int movieId, int screenId){
        Screen screen=screenService.getScreen(screenId);
        Movie movie=getMovie(movieId);
        if(movie==null) return;
        movie.getScreens().add(screen);
        screen.setMovie(movie);
        screenService.saveScreen(screen);
        movieRepository.save(movie);
    }


    @Transactional
    public void deleteScreen(int movieId,Screen screen){
        Movie movie=getMovie(movieId);
        if(movie==null) return;
        movie.getScreens().remove(screen);
        screen.setMovie(null);
        screenService.saveScreen(screen);
        movieRepository.save(movie);
    }

    @Transactional
    public void deleteScreens(int movieId){
        Movie movie=getMovie(movieId);

        Iterator<Screen> itr=movie.getScreens().iterator();
        while(itr.hasNext()){
            Screen screen=itr.next();
            itr.remove();
            screen.setMovie(null);
            screenService.saveScreen(screen);
        }
        movieRepository.save(movie);
    }
}
