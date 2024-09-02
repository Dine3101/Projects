package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.Movie;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.service.MovieService;
import org.projects.springboot.ticketbooking.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private ScreenService screenService;
    @PostMapping("movie")
    public void postMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }

    @GetMapping("movies")
    public List<Movie> getMovie(){
        return movieService.getMovies();
    }

    @PostMapping("movie/{movie-id}/screen")
    public void postScreen(@PathVariable("movie-id") int movieId, @RequestBody Screen screen){
        movieService.addScreen(movieId,screenService.getScreen(screen.getId()));
    }

    @DeleteMapping("movie")
    public void deleteMovie(@RequestBody Movie movie){
        movieService.deleteMovie(movie);
    }

}
