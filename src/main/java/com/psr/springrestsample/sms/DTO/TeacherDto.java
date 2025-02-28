package com.psr.springrestsample.sms.DTO;

import com.psr.springrestsample.sms.model.TeacherPersonalProfileModel;
import com.psr.springrestsample.sms.model.TeacherProfileModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {
    private TeacherProfileModel teacherProfile;
    private TeacherPersonalProfileModel teacherPersonalProfile;
}
