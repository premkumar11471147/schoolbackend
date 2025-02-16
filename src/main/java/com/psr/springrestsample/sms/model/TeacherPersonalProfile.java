package com.psr.springrestsample.sms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teacher_personal_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherPersonalProfile {

    @Id
    private Long teacherId; // Foreign Key from TeacherProfile

    @Column(name = "photo")
    private String photo;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "guardian_name")
    private String guardianName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "alternate_number")
    private String alternateNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "address")
    private String address;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @JsonBackReference
    private TeacherProfile teacherProfile;
}
