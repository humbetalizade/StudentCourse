package org.book.studentcourse.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentResponseDto {
    private Long studentId;
    private String name;
    private String surname;
    private Integer age;
    private List<CourseResponseDto> course;
}