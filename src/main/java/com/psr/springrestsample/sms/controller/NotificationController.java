package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.Notification;
import com.psr.springrestsample.sms.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Add or Update Notification
    @PostMapping
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.saveNotification(notification));
    }

    // Get All Notifications
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    // Get Notification by ID
    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long notificationId) {
        Optional<Notification> notification = notificationService.getNotificationById(notificationId);
        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Notification
    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}

