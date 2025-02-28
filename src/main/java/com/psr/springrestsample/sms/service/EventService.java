package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.EventModel;
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
    public EventModel saveEvent(EventModel event) {
        return eventRepository.save(event);
    }

    // Get All Events
    public List<EventModel> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get Event by ID
    public Optional<EventModel> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    // Delete Event
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
