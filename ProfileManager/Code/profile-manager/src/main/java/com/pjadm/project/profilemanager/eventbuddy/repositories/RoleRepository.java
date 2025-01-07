package com.pjadm.project.profilemanager.eventbuddy.repositories;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    @Autowired
    @Qualifier("EventBuddyEntityManagerFactory")
    private EntityManager entityManager;

    @Transactional
    public List<Role> findAllRoles(){
        List<Role> roles=entityManager.createQuery("FROM Role",Role.class).getResultList();
        return roles;
    }
}
