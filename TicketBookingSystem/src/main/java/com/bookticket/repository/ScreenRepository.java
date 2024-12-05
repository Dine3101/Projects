package org.projects.springboot.ticketbooking.repository;

import org.projects.springboot.ticketbooking.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Integer> {
    public Screen findByScreenName(String screenName);
}
