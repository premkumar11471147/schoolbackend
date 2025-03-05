package com.psr.springrestsample.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "teacher_attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TeacherAttendanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;  // Primary Key for attendance records

    @NotNull
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", nullable = false)
    private TeacherProfileModel teacher;  // Foreign Key linking to TeacherProfile

    @NotNull
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull
    @Column(name = "absent", nullable = false)
    private Boolean absent;

    @Column(name = "absent_reason")
    private String absentReason;
}
