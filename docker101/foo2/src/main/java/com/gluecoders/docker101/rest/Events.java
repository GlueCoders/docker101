package com.gluecoders.docker101.rest;

import com.gluecoders.docker101.dao.EventDao;
import com.gluecoders.docker101.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(path="/event")
public class Events {

    private static final Logger LOGGER = LoggerFactory.getLogger(Events.class);

    @Autowired
    private EventDao eventDao;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllEvents(){
        LOGGER.info("Received request to fetch all events");
        try{
            return ResponseEntity.ok(eventDao.findAll());
        }catch(Exception e){
            LOGGER.error("Error while fetching events", e);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRandomEvent(){
        LOGGER.info("Creating random event");
        try{
            Event event = new Event();
            event.setCreatedTime(new Date());
            event.setEvent(UUID.randomUUID().toString());
            eventDao.save(event);
            return ResponseEntity.ok(event);
        }catch(Exception e){
            LOGGER.error("Error while creating random event", e);
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
