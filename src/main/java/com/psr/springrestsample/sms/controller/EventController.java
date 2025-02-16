package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.Event;
import com.psr.springrestsample.sms.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Add or Update Event
    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.saveEvent(event));
    }

    // Get All Events
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    // Get Event by ID
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Long eventId) {
        Optional<Event> event = eventService.getEventById(eventId);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Event
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
}
