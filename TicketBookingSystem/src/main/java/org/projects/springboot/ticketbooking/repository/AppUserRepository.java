package org.projects.springboot.ticketbooking.repository;

import org.projects.springboot.ticketbooking.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    public AppUser findByUserId(String userId);
}
