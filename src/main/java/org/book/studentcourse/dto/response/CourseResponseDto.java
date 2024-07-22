package org.book.studentcourse.dto.response;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CourseResponseDto {
    private Long courseId;
    private String courseName;
    private String courseDescription;

}