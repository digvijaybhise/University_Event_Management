package com.geekster.UniversityEventmanagement.service;

import com.geekster.UniversityEventmanagement.model.Event;
import com.geekster.UniversityEventmanagement.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    IEventRepository eventRepository;

    public String addEvents(List<Event> eventList) {
        Iterable<Event> list = eventRepository.saveAll(eventList);
        if(list != null) return "Events added Successfully...!!!";
        return "Could not added events.";
    }

    public void updateEvent(Integer id, Event event) {
        eventRepository.save(event);
    }


    public Iterable<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findAllEventByDate(date);
    }

    public void deleteById(Integer id) {
        eventRepository.deleteById(id);
    }
}
