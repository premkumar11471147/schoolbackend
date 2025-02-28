package com.psr.springrestsample.sms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "fees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Long receiptId;  // Primary Key

    @Column(name = "ID", nullable = false)
    private String admissionID;  // Admission ID (Foreign Key)

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassModel classEntity;  // Foreign Key to Class

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private SchoolDetailsModel schoolEntity;  // Foreign Key to School

    @Column(name = "term", nullable = false)
    private String term;  // Fee Term (e.g., Semester 1, Semester 2)

    @Column(name = "date", nullable = false)
    private LocalDate date;  // Date of payment

    @Column(name = "fee_paid", nullable = false)
    private Double feePaid;  // Amount of fee paid

    @Column(name = "fee_due", nullable = false)
    private Double feeDue;  // Amount of fee due

    @Column(name = "fee_total", nullable = false)
    private Double feeTotal;  // Total Fee for the term
}
