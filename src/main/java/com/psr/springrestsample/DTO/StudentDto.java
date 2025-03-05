package com.psr.springrestsample.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String admissionId;
    private String firstName;
    private String lastName;
    private Long classId;
    private Long schoolId;
    private String rollNumber;

    // Personal profile fields
    private String dateOfBirth;
    private String gender;
    private String fatherName;
    private String motherName;
    private String phoneNumber;
    private String alternateNumber;
    private String emailId;
    private String address;
}
