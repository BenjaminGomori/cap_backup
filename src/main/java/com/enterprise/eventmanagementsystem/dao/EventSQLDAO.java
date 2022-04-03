package com.enterprise.eventmanagementsystem.dao;
import com.enterprise.eventmanagementsystem.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("eventDAO")
public class EventSQLDAO implements IEventDAO {


    @Autowired
    EventRepository eventRepository;

    @Override
    public Event fetch(int eventId) {
        return eventRepository.findById(eventId).get();
    }

    @Override
    public Iterable<Event> fetchAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event save(Event event) throws Exception {
        return eventRepository.save(event);
    }
}
