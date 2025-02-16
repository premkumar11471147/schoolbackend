package com.psr.springrestsample.sms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "class_teacher_junction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassTeacherJunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_teacher_junction_id")
    private Long id;  // Primary Key

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfile teacher;  // Foreign Key

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity;  // Foreign Key
}
