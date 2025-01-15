package com.pjadm.project.profilemanager.eventbuddy.repositories;

import java.util.List;


/** Template for Repository Layer
 *
 * @param <E> -> Entity
 * @param <P> -> Primary Key type
 */
public interface EntityRepository<E,P> {

    public void add(E entity) throws Exception;
    public List<E> findAll();

    public E find(P column) throws Exception;
    public E delete(P column) throws  Exception;

}
