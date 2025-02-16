package com.psr.springrestsample.sms.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "report_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_student_id")
    private Long reportStudentId;  // Foreign Key to Student

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private ExamTimeTable exam;  // Foreign Key to Exam

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;  // Foreign Key to Subject

    @Column(name = "marks_secured", nullable = false)
    private Double marksSecured;  // Marks secured by the student

    @Column(name = "total_marks", nullable = false)
    private Double totalMarks;  // Total marks for the subject

    @Column(name = "report_grade", nullable = false)
    private String reportGrade;  // Grade of the student

    @Column(name = "remark", nullable = true)
    private String remark;  // Remarks for the student

    @Column(name = "attendance", nullable = false)
    private Double attendance;  // Attendance percentage for the student
}

