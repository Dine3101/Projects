package org.projects.springboot.ticketbooking;

import lombok.Getter;
import org.projects.springboot.ticketbooking.model.Theatre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static ApplicationContext appContext;
    public static void main(String[] args){
        appContext=SpringApplication.run(Application.class,args);
    }
}
