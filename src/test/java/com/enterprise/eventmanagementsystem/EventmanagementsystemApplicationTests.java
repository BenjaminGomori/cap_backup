package com.enterprise.eventmanagementsystem;
import com.enterprise.eventmanagementsystem.dao.EventRepository;
import com.enterprise.eventmanagementsystem.dto.Event;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@SpringBootTest
class EventmanagementsystemApplicationTests {



    @MockBean
    private Event event= new Event();
    @MockBean
    private EventRepository eventRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void addNewEvent_displayNewEvent(){
        givenNewEventIsAvailable();
        whenCreatingNewEvent();
        thenAddNewEvent();
    }

    private void givenNewEventIsAvailable() {
    }

    private void whenCreatingNewEvent() {
        event.setId(4);
        event.setName("Birthday");
        event.setAddress("567 Main St., Cincinnati, Ohio, USA");
        event.setDate(01/28/2022);
        event.setTime(5);
        event.setDescription("It is Sam's 31st Birthday!!");

    }
    private void thenAddNewEvent() {
        Event createEvent = eventRepository.save(event);
        assertEquals(event, createEvent);
        verify(eventRepository, atLeastOnce()).save(event);
    }
    @Test
    void saveEvent_displayEventUpdate(){
        givenEventUpdates();
        whenEventUpdates();
        thenEventUpdates();
    }

    private void givenEventUpdates() {
    }
    private void whenEventUpdates() {
        event.setId(4);
        event.setName("Birthday");
        event.setAddress("567 Main St., Cincinnati, Ohio, USA");
        event.setDate(01/28/2023);
        event.setTime(5);
        event.setDescription("It is Sam's 32st Birthday!!");

    }
    private void thenEventUpdates() {
        eventRepository.save(event);
        var updateEvent = eventRepository.findById(event.getId());
        assertEquals(event, updateEvent);
        verify(eventRepository, atLeastOnce()).save(event);
    }
}
