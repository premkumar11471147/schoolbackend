package com.psr.springrestsample.sms.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "homework")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Homework {

    @Id
    @Column(name = "date")
    private String date;  // Primary Key (Date of the homework assignment)

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;  // Foreign Key to Subject

    @Column(name = "description", nullable = false)
    private String description;  // Description of the homework

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity;  // Foreign Key to Class

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private SchoolDetails schoolEntity;  // Foreign Key to School
}
