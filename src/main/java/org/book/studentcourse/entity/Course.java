package org.book.studentcourse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_Name")
    private String name;

    @Column(name = "description")
    private String description;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "courses")
    private List<Student> students;

}
