package com.bookticket.service;

import jakarta.transaction.Transactional;
import com.bookticket.model.Movie;
import com.bookticket.model.Screen;
import com.bookticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenService screenService;

    @Autowired
    @Qualifier("sampleMovie")
    private Movie sampleMovie;

    @Autowired
    @Qualifier("sampleMovieDisplay")
    private Movie sampleMovieDisplay;

    public void initSample(){
        saveMovie(sampleMovie);
        saveMovie(sampleMovieDisplay);
    }
    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }
    public Movie getMovie(int movieId){
        return movieRepository.findById(movieId).get();
    }

    public Movie getMovie(String name){
        return movieRepository.findByName(name);
    }
    public List<Movie> getMovies(){
        List<Movie> movies=movieRepository.findAll();
        return movies;
    }
    public void deleteMovie(Movie movie){
        movieRepository.delete(movie);
    }
    public Movie getSample(){
        return getMovie(1);
    }

    public void addMovie(Movie movie) throws Exception{
        if(movie.getLanguage()==null || movie.getLanguage().length()==0) throw new Exception("Please provide information for Language");
        if(getMovie(movie.getName())!=null) throw new Exception("Movie with same name is already registered");
        movie.setScreens(new LinkedList<>());
        saveMovie(movie);
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
        saveMovie(movie);
    }


    @Transactional
    public void deleteScreen(int movieId,Screen screen){
        Movie movie=getMovie(movieId);
        if(movie==null) return;
        movie.getScreens().remove(screen);
        screen.setMovie(sampleMovie);
        screenService.saveScreen(screen);
        saveMovie(movie);
    }

    @Transactional
    public void deleteScreens(int movieId){
        Movie movie=getMovie(movieId);

        Iterator<Screen> itr=movie.getScreens().iterator();
        while(itr.hasNext()){
            Screen screen=itr.next();
            itr.remove();
            screen.setMovie(sampleMovie);
            screenService.saveScreen(screen);
        }
        saveMovie(movie);
    }


}
