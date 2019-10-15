package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        }catch (Exception e)
        {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<Track>>(trackService.displaySavedTrack(),HttpStatus.OK);
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.DELETE)
    public void removeTrack(@PathVariable Integer id) {
        trackService.removeTrack(id);
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.PUT)
    public void updateComments(@RequestBody Track track, @PathVariable int id) {
        trackService.saveTrack(trackService.updateComments(id,track));
    }
}
