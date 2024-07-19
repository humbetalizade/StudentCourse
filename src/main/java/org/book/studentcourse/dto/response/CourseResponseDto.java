package org.book.studentcourse.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseDto {
    private Long courseId;
    private String courseName;
    private String courseDescription;
    private List<StudentResponseDto> student;
}