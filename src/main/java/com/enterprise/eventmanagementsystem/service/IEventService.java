package com.enterprise.eventmanagementsystem.service;
import com.enterprise.eventmanagementsystem.dto.Event;

import java.util.List;

/**
 * EventService is in charge of the logic for the Event DTO.
 * This interface displays all saved events, allows you to create a new event, delete an event, and search for one.
 * @author Ali Ibrahim, Benjamin Gomori, Kevin Zhu, and Son Bo
 */
public interface IEventService {


    Iterable<Event> fetchAll() throws Exception;

    Event save(Event event) throws Exception;

    Event fetch(int id);

    void delete(int id) throws Exception;

    List<String> generateEventsSearchableData() throws Exception;

    List<Event> searchEvents(String searchText) throws Exception;
}