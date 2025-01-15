package com.pjadm.project.profilemanager.eventbuddy.repositories;

import com.pjadm.project.profilemanager.eventbuddy.entities.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

/** Repository Layer for Movie Entity-related DB queries **/
@Repository
public class MovieRepository implements EntityRepository<Movie,String> {

    @Autowired
    @Qualifier("EventBuddyEntityManagerFactory")
    private EntityManager entityManager;
    @Override
    @Transactional
    public void add(Movie movie) throws Exception {
        entityManager.persist(movie);
    }

    @Override
    @Transactional
    public List<Movie> findAll() {
        List<Movie> movies=entityManager.createQuery("FROM Movie",Movie.class).getResultList();
        return movies;
    }

    @Override
    @Transactional
    public Movie find(String movieName) throws Exception {
        TypedQuery<Movie> query=entityManager.createQuery("FROM Movie m WHERE m.movieName=:movieName",Movie.class);
        query.setParameter("movieName",movieName);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public Movie delete(String movieName) throws Exception {
        TypedQuery<Movie> query=entityManager.createQuery("FROM Movie m WHERE m.movieName=:movieName",Movie.class);
        query.setParameter("movieName",movieName);
        Movie movie=query.getSingleResult();
        entityManager.remove(movie);
        return movie;
    }

    @Transactional
    public Movie update(String movieName,Movie newMovie) throws Exception{
        TypedQuery<Movie> query=entityManager.createQuery("FROM Movie m WHERE m.movieName=:movieName",Movie.class);
        query.setParameter("movieName",movieName);
        Movie movie=query.getSingleResult();
        movie.setProfile(newMovie);
        entityManager.merge(movie);
        return movie;
    }
}
