package com.psr.springrestsample.DTO;

import com.psr.springrestsample.model.TeacherPersonalProfileModel;
import com.psr.springrestsample.model.TeacherProfileModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto {
    private TeacherProfileModel teacherProfile;
    private TeacherPersonalProfileModel teacherPersonalProfile;
}
