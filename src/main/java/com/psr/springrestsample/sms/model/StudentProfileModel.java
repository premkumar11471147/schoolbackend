package com.psr.springrestsample.sms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generates unique ID
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "admission_id", unique = true, nullable = false)
    private String admissionId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassModel classEntity;

    @Column(name = "roll_number", nullable = false)
    private String rollNumber;

    @Column(name = "school_id", nullable = false)
    private Long schoolId;

    // Bi-directional One-to-One mapping
    @OneToOne(mappedBy = "studentProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private StudentPersonalProfileModel studentPersonalProfile;

    public void setStudentPersonalProfile(StudentPersonalProfileModel studentPersonalProfile) {
        this.studentPersonalProfile = studentPersonalProfile;
        studentPersonalProfile.setStudentProfile(this);  // Ensures relationship consistency
    }
}
