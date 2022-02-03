package com.enterprise.eventmanagementsystem.service;
import com.enterprise.eventmanagementsystem.dto.Event;

public interface IEventService {


    Iterable<Event> fetchAll() throws Exception;

    Event save(Event event) throws Exception;

    Event fetch(int id);

    void delete(int id) throws Exception;
}