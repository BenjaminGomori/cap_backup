package com.enterprise.eventmanagementsystem.controller;
import com.enterprise.eventmanagementsystem.dto.Event;
import com.enterprise.eventmanagementsystem.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class EventController {


    @Autowired
    IEventService eventService;

    @GetMapping("/")
    public String viewHomePage(Model model) throws Exception {
        model.addAttribute("listEvents", eventService.fetchAll());
        model.addAttribute("eventsSearchableData", generateEventsSearchableData());
        return "index";
    }

    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) throws Exception {
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("eventsSearchableData", generateEventsSearchableData());
        return "newEvent";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("event") Event event) throws Exception {
        eventService.save(event);
        return "redirect:/";
    }

    @PostMapping("/createEvent")
    public ResponseEntity createEvent(@RequestBody Event event) throws Exception {
        Event newEvent = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            newEvent = eventService.save(event);
        } catch (Exception e) {
            return new ResponseEntity(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(newEvent, headers, HttpStatus.OK);
    }

    @PostMapping("/saveEvent/{id}")
    public ResponseEntity saveEvent(@PathVariable("id") int id, @RequestBody Event event) throws Exception {
        Event newEvent = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            event.setId(id);
            newEvent = eventService.save(event);
        } catch (Exception e) {
            return new ResponseEntity(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(newEvent, headers, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity deleteEvent(@PathVariable("id") int id) throws Exception {
        try {
            eventService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) throws Exception{
        Event event = eventService.fetch(id);
        model.addAttribute("event", event);
        model.addAttribute("eventsSearchableData", generateEventsSearchableData());
        return "editEvent";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) throws Exception {

        this.eventService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/event")
    @ResponseBody
    public Iterable<Event> fetchAllEvents() throws Exception {
        return eventService.fetchAll();
    }

    @GetMapping("/search/{str}")
    @ResponseBody
    public List<Event> searchEvents(@PathVariable(value = "str") String str) throws Exception {
        List<Event> eventList =  new LinkedList<>();
        for (Event event:eventService.fetchAll()) {
            if(event.getName().contains(str) || event.getDescription().contains(str)){
                eventList.add(event);
            }
        }
        return eventList;
    }

        public List<String> generateEventsSearchableData() throws Exception{
            List<String> eventsSearchableData =  new LinkedList<>();
            for (Event event:eventService.fetchAll()) {
                eventsSearchableData.add(event.getName() + ", "+ event.getDescription());
            }
            return eventsSearchableData;
        }
}
