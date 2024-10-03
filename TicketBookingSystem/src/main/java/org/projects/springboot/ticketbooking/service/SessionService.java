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

    public Ticket getTicket(int sessionId,Ticket ticket){
        Session session=getSession(sessionId);
        if(session.isFull()) return null;
        int soldSeatCount=session.getTotalSeatCount()-session.getAvailableSeatCount();
        int seatId=soldSeatCount;
        int rows=session.getRows();
        int cols=session.getCols();
        String seat=(char)('a'+(seatId/cols))+""+(seatId%cols);
        StringBuilder sessionInfoBuilder=new StringBuilder();
        sessionInfoBuilder.append("Session : "+session.getSessionName()+"\n");
        sessionInfoBuilder.append("Start Time : "+session.getStartTime()+"\n");
        sessionInfoBuilder.append("End Time : "+session.getEndTime()+"\n");
        sessionInfoBuilder.append("Price : "+session.getPrice()+"\n");
        sessionInfoBuilder.append("Seat Id : "+seat+"\n");
        String sessionInfo=sessionInfoBuilder.toString();
        session.book();
        saveSession(session);
        ticket.setSessionInfo(sessionInfo);
        return ticket;
    }



}
