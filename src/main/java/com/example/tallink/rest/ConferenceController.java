package com.example.tallink.rest;

import com.example.tallink.model.Conference;
import com.example.tallink.service.ConferenceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping(value = "conference")
    @ResponseBody
    public ResponseEntity<Conference> saveConference(@Valid @RequestBody Conference conference) {
        return new ResponseEntity<>(conferenceService.saveConference(conference), HttpStatus.CREATED);
    }

    @GetMapping(value = "conference/{id}")
    @ResponseBody
    public ResponseEntity<Conference> findById(@PathVariable("id") Integer id) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("andrei", "hello");
        return new ResponseEntity<>(conferenceService.findConferenceById(id), headers, HttpStatus.OK);
    }

    @GetMapping(value = "test")
    public Map<String, String> test() {
        return Collections.singletonMap("response", "test");
    }

    @GetMapping(value = "conferences")
    @ResponseBody
    public ResponseEntity<List<Conference>> findConferences() {
        return new ResponseEntity<>(conferenceService.findConferences(), HttpStatus.OK);
    }
}

