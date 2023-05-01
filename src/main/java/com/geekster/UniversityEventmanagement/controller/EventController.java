package com.geekster.UniversityEventmanagement.controller;

import com.geekster.UniversityEventmanagement.model.Event;
import com.geekster.UniversityEventmanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

/*  Add event
    Update event
    Delete event
    Get All events by date*/

    @GetMapping("/date/{date}")
    public Iterable<Event> getByDate(@PathVariable LocalDate date){
        return eventService.getEventsByDate(date);
    }

    @PostMapping("/")
    public String addEvents(@RequestBody List<Event> eventList){
        return eventService.addEvents(eventList);
    }

    @PutMapping("/{id}")
    public void updateEvent(@PathVariable Integer id, @RequestBody Event event){
        eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable Integer id){
        eventService.deleteById(id);
    }
}
