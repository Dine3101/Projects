package com.pjadm.project.profilemanager.eventbuddy.repositories;

import com.pjadm.project.profilemanager.eventbuddy.entities.Theatre;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
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
public class TheatreRepository implements EntityRepository<Theatre,Integer> {

    @Autowired
    @Qualifier("EventBuddyEntityManagerFactory")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(Theatre theatre) throws Exception {
        entityManager.persist(theatre);
    }

    @Override
    @Transactional
    public List<Theatre> findAll() {
        return entityManager.createQuery("FROM Theatre",Theatre.class).getResultList();
    }

    @Override
    @Transactional
    public Theatre find(Integer theatreId) throws Exception {
        TypedQuery<Theatre> query=entityManager.createQuery("FROM Theatre t WHERE t.theatreId=:theatreId",Theatre.class);
        query.setParameter("theatreId",theatreId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public Theatre delete(Integer theatreId) throws Exception {
        TypedQuery<Theatre> query=entityManager.createQuery("FROM Theatre t WHERE t.theatreId=:theatreId",Theatre.class);
        query.setParameter("theatreId",theatreId);
        Theatre theatre=query.getSingleResult();
        entityManager.remove(theatre);
        return theatre;
    }

    @Transactional
    public Theatre update(Integer theatreId,Theatre newTheatre) throws Exception{
        TypedQuery<Theatre> query=entityManager.createQuery("FROM Theatre t WHERE t.theatreId=:theatreId",Theatre.class);
        query.setParameter("theatreId",theatreId);
        Theatre theatre=query.getSingleResult();
        theatre.setProfile(newTheatre);
        entityManager.merge(theatre);
        return theatre;
    }
}
