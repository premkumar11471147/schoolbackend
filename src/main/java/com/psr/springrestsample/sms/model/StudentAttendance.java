package com.psr.springrestsample.sms.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;  // Primary Key for Attendance

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentProfile student;  // Foreign Key reference to StudentProfile

    @Column(name = "date", nullable = false)
    private LocalDate date;  // Date of attendance

    @Column(name = "status", nullable = false)
    private String status;  // Present or Absent

    @Column(name = "absent_reason", nullable = true)
    private String absentReason;  // Reason if student is absent
}

