package com.conference.backend.controller;

import com.conference.backend.dto.EventDto;
import com.conference.backend.entity.Event;
import com.conference.backend.exception.AssociationException;
import com.conference.backend.exception.ContentNotFoundException;
import com.conference.backend.service.EventService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@RestController
@RequestMapping(value = "event")
public class ConferenceController {

    private static Logger logger = LoggerFactory.getLogger(ConferenceController.class.getName());

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public EventDto create(@RequestBody Event event) {
        logger.info("Inserting New Event {}", event);
        try {
            Integer min = Integer.valueOf(StringUtils.substringBefore(event.getPresentationTime(), "min"));
            if (min > 0 && StringUtils.isNotBlank(event.getHeader())) {
                return eventService.createEvent(event);
            } else {
                logger.info("Event validation exist!!");
                throw new ContentNotFoundException(String.format("Meeting does not found!! "));
            }
        } catch (Exception e) {
            logger.info("Event create does not exist!!");
            throw new ContentNotFoundException(String.format("Meeting does not found!! "));
        }
    }

    @RequestMapping(value = "/createAll", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void create(@RequestBody List<Event> events) {
        logger.info("Inserting New Event {}", events);
        eventService.createEvents(events);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    public void delete(@RequestParam(name = "oid", required = true) String oid) {
        logger.error("Event will be remove : %s" + oid);

        if (StringUtils.isNotBlank(oid)) {
            logger.info("Event does not exist!!");
            throw new AssociationException(String.format("Event not found with Department id : %s", oid));
        }
        boolean exists = eventService.exists(oid);
        if (exists) {
            try {
                eventService.deleteEventById(oid);
                logger.info("Department will be remove id : %s}", oid);
            } catch (Exception e) {
                logger.info("Event does not exist!!");
                throw new ContentNotFoundException(String.format("Event not found with Department id : %s", oid));
            }
        } else {
            logger.info("Event does not exist!!");
            throw new ContentNotFoundException(String.format("Event not found with Department id : %s", oid));
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Event> update(@RequestBody Event event) {
        boolean exists = eventService.exists(event.getOid());
        if (exists) {
            logger.info("Employee will be remove {}", event);
            Event updateConference = eventService.updateEvent(event);
            return new ResponseEntity<>(updateConference, HttpStatus.OK);
        } else {
            logger.info("Employee does not exist!!");
            throw new ContentNotFoundException(String.format("Conference not found with Event id : %s", event.getOid()));
        }
    }

    @ResponseBody
    @RequestMapping(value = "getAll")
    public List<EventDto> getAll() {
        logger.info("Fetching All Event..");
        try {
            return eventService.getAllEvents();
        } catch (Exception e) {
            logger.info("Employee does not exist!!");
            throw new AssociationException(String.format("Conference get All Exception"));
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Optional<Event> getConference(@RequestParam("oid") String oid) {
        logger.info("Fetching Event id : %s");
        if (StringUtils.isNotBlank(oid)) {
            logger.info("Event does not exist!!");
            throw new AssociationException(String.format("Event not found with Department id : %s", oid));
        }
        try {
            logger.info("Fetching event.. ID ({})", oid);
            return eventService.getEventById(oid);
        } catch (Exception e) {
            logger.info("Event does not exist!!");
            throw new ContentNotFoundException(String.format("Department not found with Department id : %s", oid));
        }
    }
}
