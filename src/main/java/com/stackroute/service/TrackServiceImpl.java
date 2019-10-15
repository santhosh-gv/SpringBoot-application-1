package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public  TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> displaySavedTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateComments(int id,Track track) {
        track.setTrackId(id);
        return track;
    }

    @Override
    public void removeTrack(int trackId) {
        trackRepository.deleteById(trackId);
    }
}
