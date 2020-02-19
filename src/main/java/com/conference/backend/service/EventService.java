package com.conference.backend.service;

import com.conference.backend.dto.EventDto;
import com.conference.backend.entity.Event;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface EventService {


    /**
     * Method to create new Events in the db using mongo-db repository.
     *
     * @param events
     */
    public void createEvents(List<Event> events);

    /**
     * Method to create new Events in the db using mongo-db repository.
     *
     * @param event
     */
    public EventDto createEvent(Event event);

    /**
     * Method to fetch all employees from the db using mongo-db repository.
     *
     * @return
     */
    public List<EventDto> getAllEvents();

    /**
     * Method to fetch employee by id using mongo-db repository.
     *
     * @param oid
     * @return
     */
    public Optional<Event> getEventById(String oid);

    /**
     * Method to delete Event by id using mongo-db repository.
     *
     * @param oid
     */
    public void deleteEventById(String oid);

    /**
     * Method to update Event by id using mongo-db repository.
     *
     * @param event
     */
    public Event updateEvent(Event event);

    /**
     * Method to delete all Events using mongo-db repository.
     */
    public void deleteAllEvents();

    /**
     * Method to exists Event using mongo-db repository.
     *
     * @param oid
     */
    boolean exists(String oid);

}
