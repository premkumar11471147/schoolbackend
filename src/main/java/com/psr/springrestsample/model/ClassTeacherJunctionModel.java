package com.psr.springrestsample.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "class_teacher_junction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassTeacherJunctionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_teacher_junction_id")
    private Long id;  // Primary Key

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfileModel teacher;  // Foreign Key

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassModel classEntity;  // Foreign Key
}
