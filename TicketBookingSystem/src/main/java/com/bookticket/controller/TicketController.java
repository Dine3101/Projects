package com.bookticket.controller;

import com.bookticket.model.Ticket;
import com.bookticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping("ticket")
    public ModelAndView getTickets(){
        List<Ticket> ticketList=ticketService.getAllTickets();
        ModelAndView mv=new ModelAndView("ticket_view");
        mv.addObject("tickets",ticketList);
        return mv;
    }
}
