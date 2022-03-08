package com.enterprise.eventmanagementsystem.service;
import com.enterprise.eventmanagementsystem.dao.EventRepository;
import com.enterprise.eventmanagementsystem.dao.IEventDAO;
import com.enterprise.eventmanagementsystem.dto.Event;
import com.enterprise.eventmanagementsystem.dto.LabelValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * The application's border is defined by this class.
 * From the standpoint of interfacing client layers, it is a set of possible operations.
 * It contains the business logic of the application, controls transactions, and coordinates replies in the execution of its operations.
 * @author Ali Ibrahim, Benjamin Gomori, Kevin Zhu, and Son Bo
 */
@Service
public class EventService implements IEventService {


    @Autowired
    IEventDAO eventDAO;

    @Autowired
    EventRepository eventRepository;

    public EventService(IEventDAO eventDAO)
    {
        this.eventDAO = eventDAO;
    }

    @Override
    public Iterable<Event> fetchAll() throws Exception {
        return eventDAO.fetchAll();
    }

    @Override
    public Event save(Event event) throws Exception {
        return eventDAO.save(event);
    }

    @Override
    public Event fetch(int id) {
        return eventDAO.fetch(id);
    }

    @Override
    @CacheEvict(value = "delete", key = "#id")
    public void delete(int id) {
        this.eventRepository.deleteById(id);
    }
    @Override
    public List<LabelValue> generateEventsSearchableData() throws Exception{
        List<LabelValue> eventsSearchableData =  new LinkedList<>();
        for (Event event: fetchAll()) {
            LabelValue labelValue = new LabelValue();
            labelValue.setValue(event.getId());
            labelValue.setLabel(event.getName() + ", "+ event.getDescription());
            eventsSearchableData.add(labelValue);
        }
        return eventsSearchableData;
    }

    @Override
    public List<Event> searchEvents(String searchText) throws Exception {
        List<Event> eventList =  new LinkedList<>();
        for (Event event: fetchAll()) {
            if(event.getName().contains(searchText) || event.getDescription().contains(searchText)){
                eventList.add(event);
            }
        }
        return eventList;
    }
}