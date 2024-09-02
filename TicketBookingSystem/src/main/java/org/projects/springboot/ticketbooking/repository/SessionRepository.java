package org.projects.springboot.ticketbooking.repository;

import org.projects.springboot.ticketbooking.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer> {
}
