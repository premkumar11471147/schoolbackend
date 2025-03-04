package com.psr.springrestsample.controller;


import com.psr.springrestsample.model.EventModel;
import com.psr.springrestsample.service.EventService;
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
    public ResponseEntity<EventModel> addEvent(@RequestBody EventModel event) {
        return ResponseEntity.ok(eventService.saveEvent(event));
    }

    // Get All Events
    @GetMapping
    public ResponseEntity<List<EventModel>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    // Get Event by ID
    @GetMapping("/{eventId}")
    public ResponseEntity<EventModel> getEventById(@PathVariable Long eventId) {
        Optional<EventModel> event = eventService.getEventById(eventId);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Event
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
}
