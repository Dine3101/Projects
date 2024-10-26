package org.projects.springboot.ticketbooking.repository;

import org.projects.springboot.ticketbooking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
