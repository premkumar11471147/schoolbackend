package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.Event;
import com.psr.springrestsample.sms.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Add or Update Event
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get All Events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get Event by ID
    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    // Delete Event
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
