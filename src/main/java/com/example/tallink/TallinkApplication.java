package com.example.tallink;

import com.example.tallink.model.Conference;
import com.example.tallink.service.ConferenceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class TallinkApplication implements CommandLineRunner {

    private final ConferenceService conferenceService;

    public TallinkApplication(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TallinkApplication.class, args);
    }

    @Override
    public void run(String... args) {
        conferenceService.saveConference(new Conference("Conference 1", Instant.now().plusSeconds(36000L)));
        conferenceService.saveConference(new Conference("Conference 2", Instant.now().plusSeconds(3600000L)));
        conferenceService.saveConference(new Conference("Conference 3", Instant.now().plusSeconds(3600000000L)));
    }
}
