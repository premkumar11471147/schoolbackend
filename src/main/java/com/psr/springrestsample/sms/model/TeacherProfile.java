package com.psr.springrestsample.sms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teacher_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;  // Primary Key

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "school_id", nullable = false)
    private Long schoolId;  // Foreign Key

    @Column(name = "teaching_classes", nullable = false)
    private String teachingClasses;

    @Column(name = "class_teacher")
    private Boolean classTeacher;

    @OneToOne(mappedBy = "teacherProfile", cascade = CascadeType.ALL)
    @JsonManagedReference
    private TeacherPersonalProfile teacherPersonalProfile;

}
