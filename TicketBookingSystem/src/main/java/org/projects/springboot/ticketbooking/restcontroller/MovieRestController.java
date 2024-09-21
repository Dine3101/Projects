package org.projects.springboot.ticketbooking.restcontroller;

import org.projects.springboot.ticketbooking.model.Movie;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.service.MovieService;
import org.projects.springboot.ticketbooking.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MovieRestController {
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
        movieService.addScreen(movieId,screen.getId());
    }

    @DeleteMapping("movie/{movie-id}")
    public void deleteMovie(@PathVariable("movie-id") int movieId){
        movieService.deleteMovie(movieId);
    }

    @DeleteMapping("movie/{movie-id}/screen")
    public void deleteMovie(@PathVariable("movie-id") int movieId,@RequestBody Screen inScreen){
        Screen screen=screenService.getScreen(inScreen.getId());
        movieService.deleteScreen(movieId,screen);
    }

}
