package org.projects.springboot.ticketbooking.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.projects.springboot.ticketbooking.model.Screen;
import org.projects.springboot.ticketbooking.model.Theatre;
import org.projects.springboot.ticketbooking.model.Ticket;
import org.projects.springboot.ticketbooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ScreenService screenService;

    @Autowired
    @Qualifier("sampleTheatre")
    private Theatre sampleTheatre;
    public void addTheatre(Theatre theatre){
        theatre.setScreens(new LinkedList<>());
        theatreRepository.save(theatre);
    }

    public Theatre getTheatre(int theatreId){
        return theatreRepository.findById(theatreId).get();
    }

    public Theatre getTheatre(String name){
        return theatreRepository.findByName(name);
    }
    @Transactional
    public void deleteTheatre(Theatre inTheatre){
        Theatre theatre=getTheatre(inTheatre.getId());
        //dropScreens(theatre);
        theatreRepository.delete(theatre);
    }

    public void deleteTheatre(int theatreId){
        deleteTheatre(getTheatre(theatreId));
    }

    public void saveTheatre(Theatre theatre){
        theatreRepository.save(theatre);
    }

    public List<Theatre> getTheatres(){
        return theatreRepository.findAll();
    }

    public void initSample(){
        addTheatre(sampleTheatre);
    }

    public Theatre getSampleTheatre(){
        return getTheatre(1);
    }

    public void addSampleScreen(int theatreId){
        Screen sampleScreen=screenService.getSampleScreen();
        addScreen(theatreId,sampleScreen);
    }
    @Transactional
    public void addScreen(int theatreId,Screen screen){
        Theatre theatre=getTheatre(theatreId);
        if(theatre==null || screen==null) return;
        screen.setTheatre(theatre);
        theatre.getScreens().add(screen);
        saveTheatre(theatre);
    }

    @Transactional
    public void addScreen(int theatreId,int screenId){
        Screen screen=screenService.getScreen(screenId);
        addScreen(theatreId,screen);
    }

    @Transactional
    public List<Screen> getScreens(int theatreId){
        Theatre theatre=getTheatre(theatreId);
        return theatre.getScreens();
    }
    @Transactional
    public void dropScreen(Theatre theatre,Screen inputScreen){
        Screen screen=screenService.getScreen(inputScreen.getId());
        screenService.dropScreen(inputScreen.getId());
        theatre.getScreens().remove(screen);
        saveTheatre(theatre);
    }
    public void dropScreen(int theatreId,Screen inputScreen){
        dropScreen(getTheatre(theatreId),inputScreen);
    }

    @Transactional
    public void dropScreens(Theatre theatre){
        List<Screen> screens=theatre.getScreens();
        screenService.dropScreens(screens);
        theatre.setScreens(new LinkedList<>());
        saveTheatre(theatre);
    }
    @Transactional
    public void dropScreens(int theatreId){
        Theatre theatre=getTheatre(theatreId);
        dropScreens(theatre);
    }

}
