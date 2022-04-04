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
import java.util.List;
import com.enterprise.eventmanagementsystem.exceptions.InvalidInputException;


/**
 * This class is in charge of all incoming requests, and sends them to the correct service and method.
 * When the response data is ready the controller sends the response back to the requester.
 * Displaying all events, adding a new event, editing event details, deleting an event, and searching for an event are all aspects of the Event Management System program.
 * @author Ali Ibrahim, Benjamin Gomori, Kevin Zhu, Son Bo.
 */
@Controller
public class EventController {

    @Autowired
    IEventService eventService;

    /**
     * List all events.
     * @param model
     * @return The index page.
     * @throws Exception
     */
    @GetMapping("/")
    public String viewHomePage(Model model) throws Exception {
        model.addAttribute("listEvents", eventService.fetchAll());
        model.addAttribute("eventsSearchableData",eventService.generateEventsSearchableData());
        return "index";
    }

    /**
     * Present New Event form.
     * @param model
     * @return new event page.
     * @throws Exception
     */
    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) throws Exception {
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("eventsSearchableData", eventService.generateEventsSearchableData());
        return "newEvent";
    }

    /**
     * Saves event to our database.
     * @param event
     * @return event information that will be saved in the database.
     * @throws Exception
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("event") Event event) throws Exception {
        eventService.save(event);
        return "redirect:/";
    }

    /**
     * Create a new Event.
     * @param event JSON Object.
     * @return new event object.
     * @throws Exception
     */
    @PostMapping("/createEvent")
    public ResponseEntity createEvent(@RequestBody Event event) throws Exception {
        if(event.getName() == null){
            throw new InvalidInputException("Id cannot be null");
        }
        Event newEvent;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        newEvent = eventService.save(event);
        return new ResponseEntity(newEvent, headers, HttpStatus.OK);
    }

    /**
     * Save an Event created.
     * @param id Save Event
     * @param event Save Event
     * @return new event object.
     * @throws Exception
     */
    @PostMapping("/saveEvent/{id}")
    public ResponseEntity saveEvent(@PathVariable("id") int id, @RequestBody Event event) throws Exception {
        Event newEvent;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        event.setId(id);
        newEvent = eventService.save(event);

        return new ResponseEntity(newEvent, headers, HttpStatus.OK);
    }

    /**
     * Delete an event.
     * @param id Delete Event
     * @return page where the deleted event does not exist anymore.
     * @throws Exception
     */
    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity deleteEvent(@PathVariable("id") int id) throws Exception {
        eventService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Get event from the service. Set event as a model attribute to pre-populate the form.
     * @param id Edit Event
     * @param model
     * @return the edit event page .
     * @throws Exception
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) throws Exception{
        Event event = eventService.fetch(id);
        model.addAttribute("event", event);
        model.addAttribute("eventsSearchableData", eventService.generateEventsSearchableData());
        return "editEvent";
    }

    /**
     * Delete event.
     * @param id Delete Event
     * @return page where the deleted event does not exist anymore.
     * @throws Exception
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) throws Exception {
        this.eventService.delete(id);
        return "redirect:/";
    }

    /**
     * Fetching all information regarding events.
     * @return all information regarding events.
     * @throws Exception
     */
    @GetMapping("/event")
    @ResponseBody
    public Iterable<Event> fetchAllEvents() throws Exception {
        return eventService.fetchAll();
    }

    /**
     * Search for an event that exists.
     * @param searchText Search for Event
     * @return all events that were similar to the search term entered into the search field.
     * @throws Exception
     */
    @GetMapping("/search/{str}")
    @ResponseBody
    public List<Event> searchEvents(@PathVariable(value = "str") String searchText) throws Exception{
        return eventService.searchEvents(searchText);
    }
}
