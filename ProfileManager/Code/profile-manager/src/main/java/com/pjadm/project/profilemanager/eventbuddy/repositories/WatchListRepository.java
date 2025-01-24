package com.pjadm.project.profilemanager.eventbuddy.repositories;

import com.pjadm.project.profilemanager.eventbuddy.entities.AppUser;
import com.pjadm.project.profilemanager.eventbuddy.entities.Movie;
import com.pjadm.project.profilemanager.eventbuddy.entities.WatchList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Repository Layer for WatchList Entity-related DB queries **/
@Repository
public class WatchListRepository implements EntityRepository<WatchList,Integer> {

    @Autowired
    @Qualifier("EventBuddyEntityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    private WatchList watchList;

    @Override
    @Transactional
    public void add(WatchList watchList) throws Exception {
        entityManager.persist(watchList);
    }

    @Transactional
    public void add(AppUser viewer, Movie movie){
        watchList.setMovie(movie);
        watchList.setViewer(viewer);
        entityManager.persist(watchList);
    }

    @Transactional
    public boolean contains(String viewerId,String movieName){
        Query query=entityManager.createQuery("SELECT COUNT(*) FROM WatchList w WHERE w.viewer.emailId=:viewerId AND w.movie.movieName=:movieName");
        query.setParameter("viewerId",viewerId);
        query.setParameter("movieName",movieName);
        int count=(int)query.getSingleResult();
        return count>=1;
    }
    @Override
    @Transactional
    public List<WatchList> findAll() {
        return entityManager.createQuery("FROM WatchList",WatchList.class).getResultList();
    }

    @Override
    @Transactional
    public WatchList find(Integer movieId) throws Exception {
        TypedQuery<WatchList> query=entityManager.createQuery("FROM WatchList w WHERE w.movieId=:movieId",WatchList.class);
        query.setParameter("movieId",movieId);
        return query.getSingleResult();
    }

    @Transactional
    public List<WatchList> find(String viewerId){
        TypedQuery<WatchList> query=entityManager.createQuery("FROM WatchList w WHERE w.viewer.emailId=:viewerId",WatchList.class);
        query.setParameter("viewerId",viewerId);
        return query.getResultList();
    }

    @Transactional
    public WatchList find(String viewerId,String movieName){
        TypedQuery<WatchList> query=entityManager.createQuery("FROM WatchList w WHERE w.viewer.emailId=:viewerId AND w.movie.movieName=:movieName",WatchList.class);
        query.setParameter("viewerId",viewerId);
        query.setParameter("movieName",movieName);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public WatchList delete(Integer movieId) throws Exception {
        TypedQuery<WatchList> query=entityManager.createQuery("FROM WatchList w WHERE w.movieId=:movieId",WatchList.class);
        query.setParameter("movieId",movieId);
        WatchList watchList= query.getSingleResult();
        entityManager.remove(watchList);
        return watchList;
    }
}
