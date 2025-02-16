package com.psr.springrestsample.sms.DTO;

import com.psr.springrestsample.sms.model.TeacherPersonalProfile;
import com.psr.springrestsample.sms.model.TeacherProfile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {
    private TeacherProfile teacherProfile;
    private TeacherPersonalProfile teacherPersonalProfile;
}
