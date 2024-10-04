package org.projects.springboot.ticketbooking.service;

import org.projects.springboot.ticketbooking.model.Ticket;
import org.projects.springboot.ticketbooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private Ticket ticket;

    public Ticket getTicket(){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }
}
