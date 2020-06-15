package com.example.tallink.service;

import com.example.tallink.model.Conference;
import com.example.tallink.repository.ConferenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Conference saveConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public Conference findConferenceById(Integer id) {
        return conferenceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Conference> findConferences() {
        return conferenceRepository.findAll();
    }
}
