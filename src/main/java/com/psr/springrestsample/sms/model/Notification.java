package com.psr.springrestsample.sms.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;  // Primary Key

    @Column(name = "heading", nullable = false)
    private String heading;  // Heading of the notification

    @Column(name = "description", nullable = false)
    private String description;  // Description of the notification

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity;  // Foreign Key to Class

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfile teacher;  // Foreign Key to Teacher
}

