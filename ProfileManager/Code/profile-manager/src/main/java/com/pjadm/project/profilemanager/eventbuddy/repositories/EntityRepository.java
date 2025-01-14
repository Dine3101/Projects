package com.pjadm.project.profilemanager.eventbuddy.repositories;

import java.util.List;


/** Template for Repository Layer **/
public interface EntityRepository<T> {

    public void add(T entity) throws Exception;
    public List<T> findAll();

    public T find(String column) throws Exception;
    public T delete(String column) throws  Exception;

}
