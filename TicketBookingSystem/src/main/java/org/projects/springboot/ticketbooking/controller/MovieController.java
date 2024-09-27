package org.projects.springboot.ticketbooking.controller;

import org.projects.springboot.ticketbooking.model.Movie;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.model.Theatre;
import org.projects.springboot.ticketbooking.service.MovieService;
import org.projects.springboot.ticketbooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private Movie movie;
    @RequestMapping("movie")
    public ModelAndView getMovies(){
        ModelAndView mv=new ModelAndView("movie_view");
        List<Movie> movies=movieService.getMovies().stream().filter(movie->movie.getId()!=1).collect(Collectors.toList());
        mv.addObject("movies",movies);
        return mv;
    }

    @RequestMapping("movie/add")
    public ModelAndView addMovieForm(){
        ModelAndView mv=new ModelAndView("movie_add-form");
        mv.addObject("movie",movie);
        return mv;
    }

    @RequestMapping("movie/{movie-id}/theatre/add")
    public ModelAndView getTheatreForm(@PathVariable("movie-id") int movieId){
        ModelAndView mv=new ModelAndView("movie_theatre-form");
        mv.addObject("movieId",movieId);
        return mv;
    }

    @RequestMapping("movie/{movie-id}/screen/choose")
    public ModelAndView chooseScreen(@PathVariable("movie-id") int movieId, @RequestParam("theatre_name") String theatreName){
        ModelAndView mv=new ModelAndView("movie_screen-add");
        mv.addObject("movieId",movieId);
        Theatre theatre=theatreService.getTheatre(theatreName);
        List<Screen> screens=new ArrayList<>();
        if(theatre!=null) screens=theatre.getScreens();
        mv.addObject("screens",screens);
        return mv;
    }

    @RequestMapping("movie/{movie-id}/screen/add")
    public String addScreen(@PathVariable("movie-id") int movieId,@RequestParam("screenId") int screenId){
        movieService.addScreen(movieId,screenId);
        return "redirect:/movie/"+movieId+"/screen/view";
    }

    @RequestMapping("movie/{movie-id}/screen/view")
    public ModelAndView getScreen(@PathVariable("movie-id") int movieId){
        ModelAndView mv=new ModelAndView("movie_screen-view");
        List<Screen> screens=movieService.getMovie(movieId).getScreens();
        mv.addObject("screens",screens);
        return mv;
    }


}
