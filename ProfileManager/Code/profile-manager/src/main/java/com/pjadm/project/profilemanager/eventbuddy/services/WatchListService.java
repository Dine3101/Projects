package com.pjadm.project.profilemanager.eventbuddy.services;

import com.pjadm.project.profilemanager.eventbuddy.entities.AppUser;
import com.pjadm.project.profilemanager.eventbuddy.entities.Movie;
import com.pjadm.project.profilemanager.eventbuddy.entities.WatchList;
import com.pjadm.project.profilemanager.eventbuddy.models.request.watchlist.WatchListRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.repositories.AppUserRepository;
import com.pjadm.project.profilemanager.eventbuddy.repositories.MovieRepository;
import com.pjadm.project.profilemanager.eventbuddy.repositories.WatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service layer for WatchList Entity-related Business logic implementation **/
@Service
public class WatchListService {

    @Autowired
    private WatchListRepository watchListRepository;

    @Autowired
    private ResponseBody<WatchList> responseBody;

    @Autowired
    private ResponseBody<List<WatchList>> responseBodyWatchList;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private MovieRepository movieRepository;
    public ResponseBody<List<WatchList>> addWatchList(WatchListRequestBody requestBody){
        try{
            AppUser viewer=appUserRepository.find(requestBody.getViewerId());
            Movie movie=movieRepository.find(requestBody.getMovieName());
            if(watchListRepository.contains(viewer.getEmailId(),movie.getMovieName())==true){
                responseBodyWatchList.setBody("FAILURE","Already added to WatchList",null);
            }else {
                watchListRepository.add(viewer,movie);
                List<WatchList> watchLists=watchListRepository.find(viewer.getEmailId());
                responseBodyWatchList.setBody("SUCCESS","Successfully added the WatchList",watchLists);
            }
        }catch (Exception e){
            responseBodyWatchList.setBody("FAILURE","Error while adding the WatchList..."+e.getMessage(),null);
        }
        return responseBodyWatchList;
    }

    public List<WatchList> getWatchList(AppUser viewer){
        return watchListRepository.find(viewer.getEmailId());
    }

    public ResponseBody<List<WatchList>> deleteWatchList(WatchListRequestBody requestBody){
        try{
            WatchList watchList=watchListRepository.find(requestBody.getViewerId(),requestBody.getMovieName());
            watchListRepository.delete(watchList.getMovieId());
            List<WatchList> watchLists=watchListRepository.find(requestBody.getViewerId());
            responseBodyWatchList.setBody("SUCCESS","Successfully deleted the WatchList",watchLists);
        }catch(Exception e){
            responseBodyWatchList.setBody("FAILURE","Error while deleting the WatchList..."+e.getMessage(),null);
        }
        return responseBodyWatchList;
    }
}
