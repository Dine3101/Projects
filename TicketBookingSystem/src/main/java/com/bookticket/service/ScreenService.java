package com.bookticket.service;

import com.bookticket.model.Screen;
import com.bookticket.model.Session;
import jakarta.transaction.Transactional;
import org.projects.springboot.ticketbooking.model.*;
import com.bookticket.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private SessionService sessionService;
    @Autowired
    @Qualifier("sampleScreen")
    private Screen sampleScreen;
    public void addScreen(Screen screen){
        screen.setSessions(new LinkedList<>());
        screenRepository.save(screen);
    }

    public Screen saveScreen(Screen screen){
        Screen resScreen=screenRepository.save(screen);
        return resScreen;
    }


    public void initSample(){
        addScreen(sampleScreen);
    }

    public Screen getSampleScreen(){
        return getScreen(1);
    }
    public List<Screen> getScreens(){

        List<Screen> screens = screenRepository.findAll();
        return screens;
    }

    public Screen getScreen(int id){
        return screenRepository.findById(id).get();
    }

    public Screen getScreen(String screenName){
        return screenRepository.findByScreenName(screenName);
    }

    @Transactional
    public void addSession(int screenId, Session session){
        Screen screen=getScreen(screenId);
        if(screen==null) return;
        sessionService.addSession(session);
        session.setScreen(screen);
        session.setTotalSeatCount(screen.getSeatCount());
        session.setAvailableSeatCount(screen.getSeatCount());
        session.setPrice(screen.getPrice());
        session.setRows(screen.getRows());
        session.setCols(screen.getCols());
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
