package com.pjadm.project.profilemanager.eventbuddy.repositories;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
/** Repository Layer for Role Entity-related DB queries **/
@Repository
public class RoleRepository implements EntityRepository<Role> {

    @Autowired
    @Qualifier("EventBuddyEntityManagerFactory")
    private EntityManager entityManager;

    @Transactional
    public List<Role> findAll(){
        List<Role> roles=entityManager.createQuery("FROM Role",Role.class).getResultList();
        return roles;
    }

    @Transactional
    public Role find(String roleName) throws Exception{
        TypedQuery<Role> query=entityManager.createQuery("FROM Role r where r.roleName=:roleName",Role.class);
        query.setParameter("roleName",roleName);
        Role role=query.getSingleResult();
        return role;
    }
    @Transactional
    public void add(Role role) throws Exception{
        entityManager.persist(role);
    }

    @Transactional
    public Role updateRole(String oldRoleName,String newRoleName) throws Exception{
        TypedQuery<Role> query=entityManager.createQuery("FROM Role r WHERE r.roleName=:oldRoleName",Role.class);
        query.setParameter("oldRoleName",oldRoleName);
        Role role=query.getSingleResult();
        role.setRoleName(newRoleName);
        entityManager.merge(role);
        return role;
    }

    @Transactional
    public Role delete(String roleName) throws Exception{
        TypedQuery<Role> query=entityManager.createQuery("FROM Role r WHERE r.roleName=:roleName",Role.class);
        query.setParameter("roleName",roleName);
        Role role=query.getSingleResult();
        entityManager.remove(role);
        return role;
    }
}
