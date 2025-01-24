package com.pjadm.project.profilemanager.eventbuddy.services;

import com.pjadm.project.profilemanager.eventbuddy.entities.Movie;
import com.pjadm.project.profilemanager.eventbuddy.models.request.movie.UpdateMovieRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service layer for Movie Entity-related Business logic implementation **/
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ResponseBody<Movie> responseBody;

    @Autowired
    private Movie movie;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public ResponseBody<Movie> getMovie(Movie movie){
        try{
            movie=movieRepository.find(movie.getMovieName());
            responseBody.setBody("SUCCESS","Successfully fetched the Movie",movie);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while fetching the Movie..."+e.getMessage(),movie);
        }
        return responseBody;
    }

    public ResponseBody<Movie> addMovie(Movie movie){
        try{
            movieRepository.add(movie);
            responseBody.setBody("SUCCESS","Successfully added the Movie",movie);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while adding the Movie..."+e.getMessage(),movie);
        }
        return responseBody;
    }

    public ResponseBody<Movie> deleteMovie(Movie movie){
        try{
            movie=movieRepository.delete(movie.getMovieName());
            responseBody.setBody("SUCCESS","Successfully deleted the Movie",movie);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while deleting the Movie..."+e.getMessage(),movie);
        }
        return responseBody;
    }

    public ResponseBody<Movie> updateMovie(UpdateMovieRequestBody updateMovieRequestBody){
        try{
            switch(updateMovieRequestBody.getPurpose()){
                case "Profile":
                    movie=movieRepository.update(updateMovieRequestBody.getMovie().getMovieName(),updateMovieRequestBody.getMovie());
                    responseBody.setBody("SUCCESS","Successfully updated the Movie",movie);
                    break;
                default:
                    responseBody.setBody("FAILURE","Invalid Purpose",null);
            }
            return responseBody;
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while updating the Movie..."+e.getMessage(),null);
        }
        return responseBody;
    }
}
