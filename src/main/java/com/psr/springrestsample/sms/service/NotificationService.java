package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.NotificationModel;
import com.psr.springrestsample.sms.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Add or Update Notification
    public NotificationModel saveNotification(NotificationModel notification) {
        return notificationRepository.save(notification);
    }

    // Get All Notifications
    public List<NotificationModel> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get Notification by ID
    public Optional<NotificationModel> getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    // Delete Notification
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}

