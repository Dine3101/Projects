package org.projects.springboot.ticketbooking.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.projects.springboot.ticketbooking.model.*;
import org.projects.springboot.ticketbooking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private SessionService sessionService;

    public void addScreen(Screen screen){
        screen.setSessions(new LinkedList<>());
        screenRepository.save(screen);
    }

    public Screen saveScreen(Screen screen){

        Screen resScreen=screenRepository.save(screen);
        return resScreen;
    }

    public List<Screen> getScreens(){

        List<Screen> screens = screenRepository.findAll();
        return screens;
    }

    public Screen getScreen(int id){
        return screenRepository.findById(id).get();
    }

    @Transactional
    public void addSession(int screenId,Session session){
        Screen screen=getScreen(screenId);
        if(screen==null) return;
        sessionService.addSession(session);
        session.setScreen(screen);
        session.setSeatCount(screen.getSeatCount());
        session.setPrice(screen.getPrice());
        saveScreen(screen);
    }

    @Transactional
    public List<Session> getSessions(int screenId){
        Screen screen=getScreen(screenId);
        return screen.getSessions();
    }
    @Transactional
    public void deleteSession(Screen screen,Session inSession){
        Session session=sessionService.getSession(inSession.getId());
        sessionService.dropSession(session);
        screen.getSessions().remove(session);
        saveScreen(screen);
    }
    public void deleteSession(int screenId,int sessionId){
        Session session=sessionService.getSession(sessionId);
        deleteSession(getScreen(screenId),session);
    }
    @Transactional
    public void deleteSessions(Screen screen){
        List<Session> sessions=screen.getSessions();
        for(Session session:sessions) deleteSession(screen,session);
    }
    public void deleteSessions(int screenId){
        deleteSessions(getScreen(screenId));
    }

    @Transactional
    public void deleteScreen(Screen inScreen){
        Screen screen=getScreen(inScreen.getId());
        sessionService.deleteSessions(screen.getSessions());
        screen.setTheatre(null);
        screenRepository.delete(screen);
    }
    public void deleteScreen(int screenId){
        deleteScreen(getScreen(screenId));
    }

    public void dropScreen(Screen screen){
        deleteScreen(screen);
    }

    public void dropScreen(int screenId){
        dropScreen(getScreen(screenId));
    }

    @Transactional
    public void dropScreens(List<Screen> screens){
        for(Screen inScreen:screens){
            Screen screen=getScreen(inScreen.getId());
            deleteSessions(screen);
            screen.setTheatre(null);
            screenRepository.delete(screen);
        }
    }


}
