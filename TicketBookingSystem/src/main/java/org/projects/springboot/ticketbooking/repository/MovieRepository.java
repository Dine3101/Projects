package org.projects.springboot.ticketbooking.repository;

import org.projects.springboot.ticketbooking.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    public Movie findByName(String name);
}
