package com.bookticket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Data
@NoArgsConstructor
@Component
@Scope("prototype")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**Movie Info**/
    private String movieName;
    private String movieLanguage;
    /**Theatre Info**/
    private String theatreName;
    private String theatreOwnerName;
    private String theatreLocation;
    /**Screen Info*/
    private String screenName;

    /**Session Info*/
    private String sessionName;
    private String sessionStartTime;
    private String sessionEndTime;
    private String sessionPrice;
    private String sessionSeatId;

    public void setMovieInfo(Movie movie){
        this.movieName=movie.getName();
        this.movieLanguage=movie.getLanguage();
    }
    public void setTheatreInfo(Theatre theatre){
        this.theatreName=theatre.getName();
        this.theatreOwnerName=theatre.getOwnerName();
        this.theatreLocation=theatre.getLocation();
    }

    public void setScreenInfo(Screen screen){
        this.screenName=screen.getScreenName();
    }

    public void setSessionInfo(Session session){
        this.sessionName=session.getSessionName();
        this.sessionStartTime=session.getStartTime();
        this.sessionEndTime=session.getEndTime();
        this.sessionPrice=String.valueOf(session.getPrice());
        if(session.isFull()) return;
        int soldSeatCount=session.getTotalSeatCount()-session.getAvailableSeatCount();
        int seatId=soldSeatCount;
        int rows=session.getRows();
        int cols=session.getCols();
        String seat=(char)('a'+(seatId/cols))+""+(seatId%cols);
        this.sessionSeatId=seat;
    }
}
