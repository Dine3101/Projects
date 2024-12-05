package org.projects.springboot.ticketbooking.service;

import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.model.Session;
import org.projects.springboot.ticketbooking.model.Theatre;
import org.projects.springboot.ticketbooking.model.Ticket;
import org.projects.springboot.ticketbooking.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TicketService ticketService;

    public void addSession(Session session){

        sessionRepository.save(session);
    }
    public void addSession(String startTime,String endTime){
        Session session=new Session();
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        addSession(session);
    }
    public Session getSession(int sessionId){
        return sessionRepository.findById(sessionId).get();
    }

    public List<Session> getAllSessions(){
        return sessionRepository.findAll();
    }
    public void saveSession(Session session){
        sessionRepository.save(session);
    }
    public void deleteSession(Session session){
        session.setScreen(null);
        sessionRepository.delete(session);
    }
    public void deleteSessions(List<Session> sessions){
        for(Session session:sessions){
            deleteSession(session);
        }
    }
    public void dropSession(Session session){
        deleteSession(session);
    }
    public void dropSession(int sessionId){
        dropSession(getSession(sessionId));
    }

    public boolean genTicket(int sessionId){
        Session session=getSession(sessionId);
        if(session.isFull()) return false;
        ticketService.genTicket(session);
        session.book();
        saveSession(session);
        return true;
    }



}
