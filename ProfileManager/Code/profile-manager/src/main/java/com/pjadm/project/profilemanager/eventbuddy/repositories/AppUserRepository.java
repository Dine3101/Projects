package com.pjadm.project.profilemanager.eventbuddy.repositories;

import com.pjadm.project.profilemanager.eventbuddy.entities.AppUser;
import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Repository Layer for AppUser Entity-related DB queries **/
@Repository
public class AppUserRepository implements EntityRepository<AppUser,String>{

    @Autowired
    @Qualifier("EventBuddyEntityManagerFactory")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(AppUser appUser) throws Exception{
        entityManager.persist(appUser);
    }

    @Override
    @Transactional
    public AppUser find(String emailId) throws Exception{
        TypedQuery<AppUser> query=entityManager.createQuery("FROM AppUser a WHERE a.emailId=:emailId",AppUser.class);
        query.setParameter("emailId",emailId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public List<AppUser> findAll(){
        List<AppUser> appUsers=entityManager.createQuery("FROM AppUser",AppUser.class).getResultList();
        return appUsers;
    }

    @Override
    @Transactional
    public AppUser delete(String emailId){
        TypedQuery<AppUser> query=entityManager.createQuery("FROM AppUser a WHERE a.emailId=:emailId",AppUser.class);
        query.setParameter("emailId",emailId);
        AppUser appUser=query.getSingleResult();
        entityManager.remove(appUser);
        return appUser;
    }

    @Transactional
    public AppUser update(String emailId,AppUser newAppUser){
        TypedQuery<AppUser> query=entityManager.createQuery("FROM AppUser a WHERE a.emailId=:emailId",AppUser.class);
        query.setParameter("emailId",emailId);
        AppUser appUser=query.getSingleResult();
        appUser.setName(newAppUser.getName());
        appUser.setPhoneNumber(newAppUser.getPhoneNumber());
        entityManager.merge(appUser);
        return appUser;
    }

    @Transactional
    public AppUser update(String emailId, Role role){
        TypedQuery<AppUser> query=entityManager.createQuery("FROM AppUser a WHERE a.emailId=:emailId",AppUser.class);
        query.setParameter("emailId",emailId);
        AppUser appUser=query.getSingleResult();
        appUser.setRole(role);
        entityManager.persist(appUser);
        return appUser;
    }


}
