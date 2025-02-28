package com.psr.springrestsample.sms.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "time_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_id")
    private Long timeId;  // Primary Key

    @Column(name = "time_from", nullable = false)
    private String timeFrom;  // Start time of the class

    @Column(name = "time_to", nullable = false)
    private String timeTo;  // End time of the class

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfileModel teacher;  // Foreign Key to Teacher

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassModel classEntity;  // Foreign Key to Class

    @Column(name = "weekdays", nullable = false)
    private String weekdays;  // Weekdays (e.g., Monday, Tuesday)

    @Column(name = "break_timings", nullable = true)
    private String breakTimings;  // Break timings (e.g., 10:30 AM - 11:00 AM)

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectModel subject;  // Foreign Key to Subject
}

