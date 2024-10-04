package org.projects.springboot.ticketbooking.service;

import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.model.Session;
import org.projects.springboot.ticketbooking.model.Ticket;
import org.projects.springboot.ticketbooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ApplicationContext applicationContext;



    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public void genTicket(Session session){
        // to add feature to display error -> session full
        Screen screen=session.getScreen();
        Ticket ticket=applicationContext.getBean(Ticket.class);
        ticket.setSessionInfo(session);
        ticket.setScreenInfo(screen);
        ticket.setMovieInfo(screen.getMovie());
        ticket.setTheatreInfo(screen.getTheatre());
        saveTicket(ticket);
    }
}
