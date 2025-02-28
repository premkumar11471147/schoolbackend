package com.psr.springrestsample.sms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "exam_time_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamTimeTableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long examId;  // Primary Key

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassModel classEntity;  // Foreign Key to Class

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectModel subject;  // Foreign Key to Subject

    @Column(name = "exam_name", nullable = false)
    private String examName;

    @Column(name = "date", nullable = false)
    private LocalDate date;  // Exam Date

    @Column(name = "time", nullable = false)
    private String time;  // Exam Time

    @Column(name = "syllabus")
    private String syllabus;  // Syllabus for the Exam
}
