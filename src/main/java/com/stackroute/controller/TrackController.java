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
    public ResponseEntity<?> displaySavedTrack(){

        ResponseEntity responseEntity;
        try {

            responseEntity= new ResponseEntity(trackService.displaySavedTrack(),HttpStatus.OK);
        }catch (Exception e)
        {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTrack(@PathVariable Integer id) {
        ResponseEntity responseEntity;
        try {
            trackService.removeTrack(id);
            responseEntity= new ResponseEntity("Successfully removed",HttpStatus.OK);
        }catch (Exception e)
        {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateComments(@RequestBody Track track, @PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(trackService.updateComments(id,track));
            responseEntity= new ResponseEntity("Successfully updated",HttpStatus.OK);
        }catch (Exception e)
        {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;

    }
}
