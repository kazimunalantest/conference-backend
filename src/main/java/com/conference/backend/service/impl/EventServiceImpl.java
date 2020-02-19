package com.conference.backend.service.impl;

import com.conference.backend.dto.EventDto;
import com.conference.backend.entity.Event;
import com.conference.backend.exception.ContentNotFoundException;
import com.conference.backend.helper.EventHelper;
import com.conference.backend.repository.EventRepository;
import com.conference.backend.service.EventService;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Kazim Unalan
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public void createEvents(List<Event> events) {
        eventRepository.saveAll(events);
    }

    @Override
    public EventDto createEvent(Event event) {
        final Event event1 = eventRepository.save(event);
        return new EventDto(event1.getOid(), event1.getHeader(), event1.getPresentationTime());
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = new LinkedList<>();
        events.addAll(eventRepository.findAll());
        List<EventDto> track1 = new LinkedList<>();
        List<EventDto> track2 = new LinkedList<>();

//        Collections.sort(allEvent, new SortByEvent());
//        Collections.reverse(allEvent);
        int trackAM = 180;
        int trackPM = 240;
        EventHelper.getListTrack(events, track1, 1, trackAM, trackPM);

        EventHelper.getListTrack(events, track2, 2, trackAM, trackPM);

        track1.addAll(track2);

        return track1;
    }


    @Override
    public Optional<Event> getEventById(String oid) {
        return eventRepository.findById(oid);
    }

    @Override
    public void deleteEventById(String oid) {
        eventRepository.deleteById(oid);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    @Override
    public boolean exists(String oid) {
        return eventRepository.existsById(oid);
    }
}
