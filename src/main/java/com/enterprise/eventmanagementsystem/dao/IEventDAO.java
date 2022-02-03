package com.enterprise.eventmanagementsystem.dao;
import com.enterprise.eventmanagementsystem.dto.Event;

public interface IEventDAO {
    Event fetch(int eventId);
    Iterable<Event> fetchAll() throws Exception;
    Event save(Event event) throws Exception;
}
