package com.enterprise.eventmanagementsystem;
import com.enterprise.eventmanagementsystem.dao.EventRepository;
import com.enterprise.eventmanagementsystem.dto.Event;
import com.enterprise.eventmanagementsystem.service.IEventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@SpringBootTest
class EventmanagementsystemApplicationTests {
    @Autowired
    private IEventService eventService;
    private Event event;

    @Test
    void contextLoads() {
    }
    @Test
    void addNewEvent_displayNewEvent() throws Exception {
        givenNewEventIsAvailable();
        whenCreatingNewEvent();
        thenAddNewEvent();
    }

    private void givenNewEventIsAvailable() {
    }

    private void whenCreatingNewEvent() throws ParseException {
        event= new Event();
        event.setId(1);
        event.setName("Birthday");
        event.setAddress("567 Main St.");
        event.setCity("Cincinnati");
        event.setState("Ohio");
        event.setCountry("USA");
        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-28 17:00:00"));
        event.setDescription("It is Sam's 31st Birthday!!");

    }
    private void thenAddNewEvent() throws Exception {
        Event createEvent = eventService.save(event);
        assertEquals(event, createEvent);
//        verify(eventService, atLeastOnce()).save(event);
    }
    @Test
    void saveEvent_displayEventUpdate() throws Exception {
        givenEventUpdates();
        whenEventUpdates();
        thenEventUpdates();
    }

    private void givenEventUpdates() {
    }
    private void whenEventUpdates() throws ParseException {
        event = new Event();
        event.setId(1);
        event.setName("Birthday");
        event.setAddress("567 Main St.");
        event.setCity("Cincinnati");
        event.setState("Ohio");
        event.setCountry("USA");
        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-01-28 17:00:00"));
        event.setDescription("It is Sam's 32nd Birthday!!");
    }
    private void thenEventUpdates() throws Exception {
        eventService.save(event);
        var updateEvent = eventService.fetch(event.getId());
        assertEquals(event, updateEvent);
//        verify(eventService, atLeastOnce()).save(event);
    }
    @Test
    void deleteEvent() throws Exception {
        whenEventDeletes();
        thenDeleteEvent();
    }
    private void whenEventDeletes() throws ParseException {
        event = new Event();
        event.setId(2);
        event.setName("Monthly Office Event");
        event.setAddress("456 Salt Rd.");
        event.setCity("Sydney");
        event.setState("Ohio");
        event.setCountry("USA");
        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-04-25 17:00:00"));
        event.setDescription("Office monthly happy hour - Bowling");
    }
    private void thenDeleteEvent() throws Exception {
        List<Event> eventList = new ArrayList<>();
        eventService.save(event);
        for (Event event: eventService.fetchAll()) {
            eventList.add(event);
        }
        var deletedEvent = eventService.fetch(event.getId());
        assertTrue(eventList.contains(deletedEvent));
        eventService.delete(event.getId());
        eventList = StreamSupport.stream(eventService.fetchAll().spliterator(), false).collect(Collectors.toList());
        assertFalse(eventList.contains(deletedEvent));
    }
    @Test
    void searchEvent() throws Exception {
        whenEventDeletes();
        eventService.save(event);
        whenSearchingEvent();
        thenSearchEvent();
    }

    private void thenSearchEvent() throws Exception {
        eventService.save(event);
        List<Event> eventList = eventService.searchEvents(event.getName());
        assertEquals(2, eventList.size());
    }

    private void whenSearchingEvent() throws ParseException {
        event= new Event();
        event.setId(3);
        event.setName("Birthday");
        event.setAddress("567 Main St.");
        event.setCity("Cincinnati");
        event.setState("Ohio");
        event.setCountry("USA");
        event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-28 17:00:00"));
        event.setDescription("It is Sam's 50th Birthday!!");
    }
}
