package com.psr.springrestsample.sms.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "school_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long schoolId;  // Primary Key

    @Column(name = "school_name", nullable = false)
    private String schoolName;  // School Name

    @Column(name = "school_branch", nullable = false)
    private String schoolBranch;  // Branch of the School

    @Column(name = "school_contact_name", nullable = false)
    private String schoolContactName;  // Contact Person Name

    @Column(name = "school_number", nullable = false)
    private String schoolNumber;  // Contact Number

    @Column(name = "school_address", nullable = false)
    private String schoolAddress;  // School Address
}
