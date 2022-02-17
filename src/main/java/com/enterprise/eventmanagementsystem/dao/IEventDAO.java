package com.enterprise.eventmanagementsystem.dao;
import com.enterprise.eventmanagementsystem.dto.Event;

/**
 * An interface. The implementing class handles all the CRUD operations with the data source related to the Event entity or table.
 * @author Ali Ibrahim, Benjamin Gomori, Kevin Zhu, and Son Bo
 */
public interface IEventDAO {
    Event fetch(int eventId);
    Iterable<Event> fetchAll() throws Exception;
    Event save(Event event) throws Exception;
}
