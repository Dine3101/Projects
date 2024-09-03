package org.projects.springboot.ticketbooking.controller;

import org.projects.springboot.ticketbooking.model.Movie;
import org.projects.springboot.ticketbooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private Movie movie;
    @RequestMapping("movie")
    public ModelAndView getMovies(){
        ModelAndView mv=new ModelAndView("movie_view");
        List<Movie> movies=movieService.getMovies();
        mv.addObject("movies",movies);
        return mv;
    }

    @RequestMapping("movie/add")
    public ModelAndView addMovieForm(){
        ModelAndView mv=new ModelAndView("movie_add-form");
        mv.addObject("movie",movie);
        return mv;
    }

}
