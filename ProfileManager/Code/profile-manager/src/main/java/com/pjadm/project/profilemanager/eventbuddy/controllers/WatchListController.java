package com.pjadm.project.profilemanager.eventbuddy.controllers;

import com.pjadm.project.profilemanager.eventbuddy.entities.AppUser;
import com.pjadm.project.profilemanager.eventbuddy.entities.WatchList;
import com.pjadm.project.profilemanager.eventbuddy.models.request.watchlist.WatchListRequestBody;
import com.pjadm.project.profilemanager.eventbuddy.models.response.ResponseBody;
import com.pjadm.project.profilemanager.eventbuddy.services.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Rest API controller for WatchList Entity-related queries **/
@RestController
@RequestMapping("eventbuddy/watchlist")
public class WatchListController {

    @Autowired
    private WatchListService watchListService;

    @PostMapping("")
    public ResponseBody<List<WatchList>> addWatchList(@RequestBody WatchListRequestBody requestBody){
        return watchListService.addWatchList(requestBody);
    }

    @GetMapping("")
    public List<WatchList> getWatchList(@RequestBody AppUser viewer){
        return watchListService.getWatchList(viewer);
    }

    @DeleteMapping("")
    public ResponseBody<List<WatchList>> deleteWatchList(@RequestBody WatchListRequestBody requestBody){
        return watchListService.deleteWatchList(requestBody);
    }

}
