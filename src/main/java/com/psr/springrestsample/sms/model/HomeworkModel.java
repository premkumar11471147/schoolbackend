package com.psr.springrestsample.sms.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "homework")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkModel {

    @Id
    @Column(name = "date")
    private String date;  // Primary Key (Date of the homework assignment)

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectModel subject;  // Foreign Key to Subject

    @Column(name = "description", nullable = false)
    private String description;  // Description of the homework

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassModel classEntity;  // Foreign Key to Class

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private SchoolDetailsModel schoolEntity;  // Foreign Key to School
}
