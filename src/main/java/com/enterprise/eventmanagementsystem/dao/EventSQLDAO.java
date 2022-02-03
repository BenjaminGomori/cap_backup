package com.enterprise.eventmanagementsystem.dao;
import com.enterprise.eventmanagementsystem.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("eventDAO")
public class EventSQLDAO  implements IEventDAO {
    Map<Integer, Event> allEvents = new HashMap<>();


    @Autowired
    EventRepository eventRepository;

    @Override
    public Event fetch(int eventId) {
        return eventRepository.findById(eventId).get();
    }

    @Override
    public Iterable<Event> fetchAll() throws Exception {
        return eventRepository.findAll();
    }

    @Override
    public Event save(Event event) throws Exception {
        Event save = eventRepository.save(event);
        return save;
    }
}
