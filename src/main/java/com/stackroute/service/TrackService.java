package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {

    // save track
    public Track saveTrack(Track track);

    //display track
    public List<Track> displaySavedTrack();

    //update comments
    public Track updateComments(int id,Track track);

    //remove  track
    public void removeTrack(int trackId);

}
