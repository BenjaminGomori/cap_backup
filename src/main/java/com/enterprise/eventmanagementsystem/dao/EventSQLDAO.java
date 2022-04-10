package com.enterprise.eventmanagementsystem.dao;
import com.enterprise.eventmanagementsystem.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository("eventDAO")
@Profile({"dev", "default"})
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

    @Override
    public void deleteById(int id) throws Exception {
        eventRepository.deleteById(id);
    }
}
