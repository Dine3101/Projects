package com.bookticket.restcontroller;

import com.bookticket.service.ScreenService;
import com.bookticket.model.Movie;
import com.bookticket.model.Screen;
import com.bookticket.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity postMovie(@RequestBody Movie movie){
        try {
            movieService.addMovie(movie);
            return ResponseEntity.ok("Movie added successfully");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
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
