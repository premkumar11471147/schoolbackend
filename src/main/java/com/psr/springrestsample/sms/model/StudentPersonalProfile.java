package com.psr.springrestsample.sms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "student_personal_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentPersonalProfile {

    @Id
    @Column(name = "student_id")  // Uses the same ID as StudentProfile
    private Long studentId;

    @Column(name = "photo")
    private String photo;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "alternate_number")
    private String alternateNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "address")
    private String address;

    // Foreign Key Mapping
    @OneToOne
    @MapsId  // Ensures StudentPersonalProfile shares the same ID as StudentProfile
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private StudentProfile studentProfile;
}
