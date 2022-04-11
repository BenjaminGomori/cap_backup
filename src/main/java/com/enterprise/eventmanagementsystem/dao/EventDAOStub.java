package com.enterprise.eventmanagementsystem.dao;

import com.enterprise.eventmanagementsystem.dto.Event;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("test")
public class EventDAOStub implements IEventDAO {

    Map<Integer, Event> events = new HashMap<>();
    int newEventId = 1;

    @Override
    public Event fetch(int eventId) {
        return events.get(eventId);
    }

    @Override
    public Iterable<Event> fetchAll() {
        List<Event> returnEvents = new ArrayList(events.values());
        return returnEvents;
    }

    @Override
    public Event save(Event event) throws Exception {
        //when updating event id is not 0
        if (event.getId() == 0) {
            event.setId(newEventId++);
        }
        events.put(event.getId(), event);
        return event;
    }

    @Override
    public void deleteById(int id) {
        events.remove(id);
    }
}