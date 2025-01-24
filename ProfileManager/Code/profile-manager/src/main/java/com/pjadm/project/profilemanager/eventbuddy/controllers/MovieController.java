package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.Movie;
import com.pjadm.project.profilemanager.eventbuddy.models.request.movie.UpdateMovieRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Rest API controller for Movie Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("")
    public ResponseBody<Movie> getMovie(@RequestBody Movie movie){
        return movieService.getMovie(movie);
    }

    @PostMapping("")
    public ResponseBody<Movie> addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @DeleteMapping("")
    public ResponseBody<Movie> deleteMovie(@RequestBody Movie movie){
        return movieService.deleteMovie(movie);
    }

    @PatchMapping("")
    public ResponseBody<Movie> updateMovie(@RequestBody UpdateMovieRequestBody updateMovieRequestBody){
        return movieService.updateMovie(updateMovieRequestBody);
    }
}
