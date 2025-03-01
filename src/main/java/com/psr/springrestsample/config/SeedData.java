package com.psr.springrestsample.config;

import com.psr.springrestsample.sms.model.*;
import com.psr.springrestsample.sms.repository.*;
import com.psr.springrestsample.sms.service.ClassService;
import com.psr.springrestsample.sms.service.StudentProfileService;
import com.psr.springrestsample.sms.service.TeacherProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.psr.springrestsample.model.Account;
import com.psr.springrestsample.service.AccountService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Component
public class SeedData  implements CommandLineRunner {


    @Autowired
    private AccountService accountService;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private TeacherProfileService teacherProfileService;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ExamTimeTableRepository examTimeTableRepository;
    @Autowired
    private StudentProfileRepository studentProfileRepository;
    @Autowired
    private TeacherProfileRepository teacherProfileRepository;
    @Autowired
    private SchoolDetailsRepository schoolDetailsRepository;
    @Autowired
    private FeesRepository feesRepository;
    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private ReportCardRepository reportCardRepository;
    @Autowired
    private StudentProfileService studentProfileService;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentAttendanceRepository studentAttendanceRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TeacherAttendanceRepository teacherAttendanceRepository;
    @Autowired
    private TimeTableRepository timeTableRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public void run(String... args) throws Exception {

        Account account1 = new Account();
        Account account2 = new Account();


        account1.setEmail("user@user.com");
        account1.setPassword("pass987");
        account1.setRole("ROLE_USER");
        accountService.save(account1);


        account2.setEmail("admin@admin.com");
        account2.setPassword("pass987");
        account2.setRole("ROLE_ADMIN");
        accountService.save(account2);


        Date utilDate = new Date(); // Current date and time
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


        for (long i = 1; i < 10; i++) {
            ClassModel classEntity = new ClassModel();
            classEntity.setClassId(i);
            classEntity.setClassName("5th" + i);
            classEntity.setClassSection("a");

            classService.saveClass(classEntity);
        }

        List<SchoolDetailsModel> schools = Arrays.asList(
                new SchoolDetailsModel(null, "Greenwood High School", "Main Branch", "Mr. John Doe", "9876543210", "123, Park Street, New York"),
                new SchoolDetailsModel(null, "Springfield Public School", "North Branch", "Ms. Jane Smith", "8765432109", "456, Maple Avenue, Los Angeles"),
                new SchoolDetailsModel(null, "Bluebell Academy", "South Campus", "Mr. Robert Brown", "7654321098", "789, Oak Street, Chicago"),
                new SchoolDetailsModel(null, "Sunshine International", "East Wing", "Mrs. Emily White", "6543210987", "321, Pine Road, Houston"),
                new SchoolDetailsModel(null, "Hilltop School", "West Zone", "Dr. Mark Wilson", "5432109876", "567, Elm Drive, San Francisco")
        );

// Saving the school records into the database
        schoolDetailsRepository.saveAll(schools);

        System.out.println("✅ Successfully seeded school details into the database!");


        Optional<ClassModel> classEntityOptional = classRepository.findById(1L);
        if (classEntityOptional.isPresent()) {
            ClassModel classEntity = classEntityOptional.get();

            for (long i = 1; i <= 10; i++) {
                // Creating a student profile
                StudentProfileModel student = new StudentProfileModel();
                student.setClassEntity(classEntity);
                student.setAdmissionId("stud001" + i);
                student.setFirstName("John" + i);
                student.setLastName("Doe" + i);
                student.setRollNumber("R001" + i);
                student.setSchoolId(1L);

                // Creating personal profile
                StudentPersonalProfileModel personalProfile = new StudentPersonalProfileModel();
                personalProfile.setPhoto("photo" + i + ".jpg");
                personalProfile.setDateOfBirth("2001-01-01");
                personalProfile.setGender("Male");
                personalProfile.setFatherName("Mr. Doe" + i);
                personalProfile.setMotherName("Mrs. Doe" + i);
                personalProfile.setPhoneNumber("987654321" + i);
                personalProfile.setAddress("123 Street" + i);

                // Linking both profiles
                student.setStudentPersonalProfile(personalProfile);

                // Saving student (this will automatically save personal profile)
                studentProfileRepository.save(student);

                // Creating attendance record
                StudentAttendanceModel attendance = new StudentAttendanceModel();
                attendance.setStudent(student);
                attendance.setDate(LocalDate.now()); // Set current date
                attendance.setStatus(i % 2 == 0 ? "Present" : "Absent"); // Alternate Present/Absent
                attendance.setAbsentReason(i % 2 == 0 ? null : "Personal Leave");

                // Saving attendance record
                studentAttendanceRepository.save(attendance);
            }

            System.out.println("✅ Successfully seeded 10 students into the database!");



            for (long i = 1; i <= 10; i++) {
                // Creating a teacher profile
                TeacherProfileModel teacher = new TeacherProfileModel();
                teacher.setFirstName("Teacher" + i);
                teacher.setLastName("Smith" + i);
                teacher.setSchoolId(1L);
                teacher.setTeachingClasses("Class " + (i % 5 + 1)); // Assigning classes dynamically
                teacher.setClassTeacher(i % 2 == 0); // Alternate teachers as class teachers

                // Creating personal profile
                TeacherPersonalProfileModel personalProfile = new TeacherPersonalProfileModel();
                personalProfile.setTeacherId(i); // Use the same ID for personal profile
                personalProfile.setPhoto("teacher_photo" + i + ".jpg");
                personalProfile.setDateOfBirth("1980-01-01");
                personalProfile.setGender(i % 2 == 0 ? "Male" : "Female"); // Assigning gender alternately
                personalProfile.setGuardianName("Guardian" + i);
                personalProfile.setPhoneNumber("98765432" + i);
                personalProfile.setAlternateNumber("91234567" + i);
                personalProfile.setEmailId("teacher" + i + "@school.com");
                personalProfile.setAddress("456 Teacher Street" + i);

                // Linking both profiles
                personalProfile.setTeacherProfile(teacher);
                teacher.setTeacherPersonalProfile(personalProfile);


                // Saving teacher (this will automatically save personal profile)
                teacherProfileRepository.save(teacher);

                TeacherAttendanceModel attendance = new TeacherAttendanceModel();
                attendance.setTeacher(teacher);
                attendance.setDate(new Date()); // Set current date
                attendance.setAbsent(i % 3 == 0); // Every 3rd teacher is absent
                attendance.setAbsentReason(i % 3 == 0 ? "Medical Leave" : null);

                // Saving attendance record
                teacherAttendanceRepository.save(attendance);




            }

            System.out.println("✅ Successfully seeded 10 teachers into the database!");

            for (long i = 1; i <= 5; i++) {
                // Creating event data
                EventModel event = new EventModel();
                event.setHeading("Event " + i);
                event.setDescription("This is a description for event " + i + ". The event will be held at the school premises.");
                event.setDate(LocalDate.now().plusDays(i * 3)); // Events scheduled for future dates

                // Saving event into the database
                eventRepository.save(event);
            }

            System.out.println("✅ Successfully seeded 5 events into the database!");

            for (long i = 1; i <= 5; i++) {
                // Creating subject data
                SubjectModel subject = new SubjectModel();
                subject.setSubjectName("Subject " + i);
                subject.setSubjectProjectWork("Project work details for Subject " + i);
                subject.setSubjectAssignment("Assignment details for Subject " + i);
                subject.setSubjectRunningNotes("Running notes for Subject " + i);

                // Saving subject into the database
                subjectRepository.save(subject);
            }

            System.out.println("✅ Successfully seeded 5 subjects into the database!");


            List<ClassModel> classes = classRepository.findAll();
            List<SubjectModel> subjects = subjectRepository.findAll();

            if (!classes.isEmpty() && !subjects.isEmpty()) {
                for (long i = 1; i <= 5; i++) {
                    ClassModel classModel = classes.get((int) (i % classes.size())); // Rotating classes
                    SubjectModel subjectEntity = subjects.get((int) (i % subjects.size())); // Rotating subjects

                    // Creating exam timetable entry
                    ExamTimeTableModel exam = new ExamTimeTableModel();
                    exam.setClassEntity(classModel);
                    exam.setSubject(subjectEntity);
                    exam.setExamName("Midterm Exam " + i);
                    exam.setDate(LocalDate.now().plusDays(i * 7)); // Exams scheduled weekly
                    exam.setTime("10:00 AM - 12:00 PM");
                    exam.setSyllabus("Chapters 1-" + (i + 2)); // Dynamic syllabus range

                    // Saving exam timetable into the database
                    examTimeTableRepository.save(exam);
                }

                System.out.println("✅ Successfully seeded 5 exam timetables into the database!");
            } else {
                System.out.println("❌ No classes or subjects found. Exam seeding failed.");
            }


            List<StudentProfileModel> students = studentProfileRepository.findAll();

            if (!classes.isEmpty() && !schools.isEmpty() && !students.isEmpty()) {
                for (long i = 1; i <= 10; i++) {
                    ClassModel classModel = classes.get((int) (i % classes.size())); // Rotating classes
                    SchoolDetailsModel schoolEntity = schools.get((int) (i % schools.size())); // Rotating schools
                    StudentProfileModel student = students.get((int) (i % students.size())); // Rotating students

                    // Creating fee entry
                    FeesModel fee = new FeesModel();
                    fee.setAdmissionID(student.getAdmissionId()); // Linking to student's admission ID
                    fee.setClassEntity(classModel);
                    fee.setSchoolEntity(schoolEntity);
                    fee.setTerm("Semester " + ((i % 2) + 1)); // Alternating terms (Semester 1, Semester 2)
                    fee.setDate(LocalDate.now().minusDays(i * 5)); // Fee payment dates spread over time
                    fee.setFeeTotal(50000.0); // Example total fee amount
                    fee.setFeePaid(25000.0 + (i * 1000)); // Simulating different payments
                    fee.setFeeDue(fee.getFeeTotal() - fee.getFeePaid()); // Calculating due fee

                    // Saving fee record into the database
                    feesRepository.save(fee);
                }

                System.out.println("✅ Successfully seeded 10 fee records into the database!");
            } else {
                System.out.println("❌ No classes, schools, or students found. Fee seeding failed.");
            }

            if (!classes.isEmpty() && !schools.isEmpty() && !subjects.isEmpty()) {
                for (long i = 1; i <= 10; i++) {
                    ClassModel classModel = classes.get((int) (i % classes.size())); // Rotating classes
                    SchoolDetailsModel schoolEntity = schools.get((int) (i % schools.size())); // Rotating schools
                    SubjectModel subject = subjects.get((int) (i % subjects.size())); // Rotating subjects

                    // Creating homework entry
                    HomeworkModel homework = new HomeworkModel();
                    homework.setDate(LocalDate.now().minusDays(i).toString()); // Assigning different past dates
                    homework.setSubject(subject);
                    homework.setDescription("Complete Chapter " + i + " of " + subject.getSubjectName());
                    homework.setClassEntity(classModel);
                    homework.setSchoolEntity(schoolEntity);

                    // Saving homework record into the database
                    homeworkRepository.save(homework);
                }

                System.out.println("✅ Successfully seeded 10 homework records into the database!");
            } else {
                System.out.println("❌ No classes, schools, or subjects found. Homework seeding failed.");
            }



            List<TeacherProfileModel> teachers = teacherProfileRepository.findAll();

            if (!classes.isEmpty() && !teachers.isEmpty()) {
                for (long i = 1; i <= 10; i++) {
                    ClassModel classModel = classes.get((int) (i % classes.size())); // Rotating classes
                    TeacherProfileModel teacher = teachers.get((int) (i % teachers.size())); // Rotating teachers

                    // Creating a notification entry
                    NotificationModel notification = new NotificationModel();
                    notification.setHeading("Important Update " + i);
                    notification.setDescription("Dear students, please note that your upcoming exam schedule has been updated. Check the details with your class teacher.");
                    notification.setClassEntity(classModel);
                    notification.setTeacher(teacher);

                    // Saving notification record into the database
                    notificationRepository.save(notification);
                }

                System.out.println("✅ Successfully seeded 10 notification records into the database!");
            } else {
                System.out.println("❌ No classes or teachers found. Notification seeding failed.");
            }


            List<ExamTimeTableModel> exams = examTimeTableRepository.findAll();

            if (!students.isEmpty() && !exams.isEmpty()) {
                for (long i = 1; i <= 10; i++) {
                    StudentProfileModel student = students.get((int) (i % students.size())); // Rotating students
                    ExamTimeTableModel exam = exams.get((int) (i % exams.size())); // Rotating exams

                    // Generating random marks secured
                    double totalMarks = 100.0;
                    double marksSecured = (Math.random() * (totalMarks - 30)) + 30; // Ensuring minimum 30 marks

                    // Assigning grade based on marks
                    String grade;
                    if (marksSecured >= 90) grade = "A+";
                    else if (marksSecured >= 80) grade = "A";
                    else if (marksSecured >= 70) grade = "B";
                    else if (marksSecured >= 60) grade = "C";
                    else if (marksSecured >= 50) grade = "D";
                    else grade = "F";

                    // Generating random attendance percentage
                    double attendance = (Math.random() * 20) + 80; // Ensuring 80% to 100% attendance

                    // Creating a report card entry
                    ReportCardModel reportCard = new ReportCardModel();
                    reportCard.setStudent(student);
                    reportCard.setExam(exam);
                    reportCard.setMarksSecured(marksSecured);
                    reportCard.setTotalMarks(totalMarks);
                    reportCard.setReportGrade(grade);
                    reportCard.setRemark(grade.equals("F") ? "Needs Improvement" : "Good Performance");
                    reportCard.setAttendance(attendance);

                    // Saving report card record into the database
                    reportCardRepository.save(reportCard);
                }

                System.out.println("✅ Successfully seeded 10 report card records into the database!");
            } else {
                System.out.println("❌ No students or exams found. Report card seeding failed.");
            }


            List<SectionModel> sections = Arrays.asList(
                    new SectionModel(0, "A"),
                    new SectionModel(0, "B"),
                    new SectionModel(0, "C"),
                    new SectionModel(0, "D"),
                    new SectionModel(0, "E")
            );

// Saving the section records into the database
            sectionRepository.saveAll(sections);

            System.out.println("✅ Successfully seeded section details into the database!");


            Optional<TeacherProfileModel> teacherOptional = teacherProfileRepository.findById(1L);
            Optional<SubjectModel> subjectOptional = subjectRepository.findById(1L);

            if (teacherOptional.isPresent() && subjectOptional.isPresent()) {
                ClassModel classModel = classEntityOptional.get();
                TeacherProfileModel teacher = teacherOptional.get();
                SubjectModel subject = subjectOptional.get();

                String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

                for (int i = 0; i < weekdays.length; i++) {
                    TimeTableModel timeTable = new TimeTableModel();
                    timeTable.setTimeFrom("09:00 AM");
                    timeTable.setTimeTo("10:00 AM");
                    timeTable.setTeacher(teacher);
                    timeTable.setClassEntity(classModel);
                    timeTable.setSubject(subject);
                    timeTable.setWeekdays(weekdays[i]);
                    timeTable.setBreakTimings(i == 2 ? "10:30 AM - 11:00 AM" : null); // Break on Wednesday

                    // Saving the timetable record
                    timeTableRepository.save(timeTable);
                }

                System.out.println("✅ Successfully seeded timetable for the class!");
            } else {
                System.out.println("⚠️ Required data (Class, Teacher, or Subject) not found!");
            }


        }
    }
}
