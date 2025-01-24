package com.pjadm.project.profilemanager.eventbuddy.services;

import com.pjadm.project.profilemanager.eventbuddy.entities.Theatre;
import com.pjadm.project.profilemanager.eventbuddy.models.request.theatre.UpdateTheatreRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service layer for Theatre Entity-related Business logic implementation **/
@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ResponseBody<Theatre> responseBody;

    @Autowired
    private Theatre theatre;

    public ResponseBody<Theatre> addTheatre(Theatre theatre){
        try{
            theatreRepository.add(theatre);
            responseBody.setBody("SUCCESS","Successfully added the Theatre",theatre);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while adding the Theatre..."+e.getMessage(),theatre);
        }
        return responseBody;
    }

    public List<Theatre> getTheatres(){
        return theatreRepository.findAll();
    }

    public ResponseBody<Theatre> getTheatre(Theatre theatre){
        try{
            theatre=theatreRepository.find(theatre.getTheatreId());
            responseBody.setBody("SUCCESS","Successfully fetched the Theatre",theatre);
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while fetching the Theatre..."+e.getMessage(),theatre);
        }
        return responseBody;
    }

    public ResponseBody<Theatre> deleteTheatre(Theatre theatre){
        try{
            theatre=theatreRepository.delete(theatre.getTheatreId());
            responseBody.setBody("SUCCESS","Successfully deleted the Theatre",theatre);
        }catch(Exception e){
            responseBody.setBody("FAILURE","Error while deleting the Theatre..."+e.getMessage(),theatre);
        }
        return responseBody;
    }

    public ResponseBody<Theatre> updateTheatre(UpdateTheatreRequestBody updateTheatreRequestBody){
        try{
            switch(updateTheatreRequestBody.getPurpose()){
                case "Profile":
                    theatre=theatreRepository.update(updateTheatreRequestBody.getTheatre().getTheatreId(),updateTheatreRequestBody.getTheatre());
                    responseBody.setBody("SUCCESS","Successfully updated the Theatre",theatre);
                    break;
                default:
                    responseBody.setBody("FAILURE","Invalid Purpose",null);
            }
            return responseBody;
        }catch (Exception e){
            responseBody.setBody("FAILURE","Error while updating the Theatre..."+e.getMessage(),null);
        }
        return responseBody;
    }
}
