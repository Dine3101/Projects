package com.pjadm.project.profilemanager.eventbuddy.repositories;

import com.pjadm.project.profilemanager.eventbuddy.entities.Role;
import com.pjadm.project.profilemanager.eventbuddy.models.request.role.UpdateRoleRequestBody;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void addRole(Role role) throws Exception{
        entityManager.persist(role);
    }

    @Transactional
    public Role updateRole(UpdateRoleRequestBody updateRoleRequestBody) throws Exception{
        TypedQuery<Role> query=entityManager.createQuery("FROM Role r WHERE r.roleName=:roleName",Role.class);
        query.setParameter("roleName",updateRoleRequestBody.getOldRoleName());
        Role role = query.getSingleResult();
        role.setRoleName(updateRoleRequestBody.getNewRoleName());
        entityManager.merge(role);
        return role;
    }

    @Transactional
    public void deleteRole(Role role) throws Exception{
        TypedQuery<Role> query=entityManager.createQuery("FROM Role r WHERE r.roleName=:roleName",Role.class);
        query.setParameter("roleName",role.getRoleName());
        role=query.getSingleResult();
        entityManager.remove(role);
    }
}
