package com.psr.springrestsample.sms.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;  // Primary Key for Subject

    @Column(name = "subject_name", nullable = false)
    private String subjectName;  // Name of the subject

    @Column(name = "subject_project_work", nullable = true)
    private String subjectProjectWork;  // Information about the subject's project work

    @Column(name = "subject_assignment", nullable = true)
    private String subjectAssignment;  // Information about subject-related assignments

    @Column(name = "subject_running_notes", nullable = true)
    private String subjectRunningNotes;  // Notes for the subject
}

