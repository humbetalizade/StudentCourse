package org.book.studentcourse.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private String surname;
    private Integer age;
    private Long courseId;
}
