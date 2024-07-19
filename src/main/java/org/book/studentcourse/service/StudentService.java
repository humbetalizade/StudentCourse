package org.book.studentcourse.service;


import lombok.RequiredArgsConstructor;
import org.book.studentcourse.dto.request.StudentRequestDto;
import org.book.studentcourse.dto.response.CourseResponseDto;
import org.book.studentcourse.dto.response.StudentResponseDto;
import org.book.studentcourse.entity.Course;
import org.book.studentcourse.entity.Student;
import org.book.studentcourse.repository.CourseRepository;
import org.book.studentcourse.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;

    public void createStudent(StudentRequestDto student) {
        Student student2 = modelMapper.map(student, Student.class);
        List<Long>courseId= Collections.singletonList(student.getCourseId());
        List<Course> courses = new ArrayList<>();
        for(Long id : courseId){
            Course course = courseRepository.findById(id).orElseThrow();
            courses.add(course);
        }
        student2.setCourses(courses);
        studentRepository.save(student2);
    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(item->modelMapper.map(item,StudentResponseDto.class))
                .collect(Collectors.toList());
    }

    public StudentResponseDto findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return modelMapper.map(student, StudentResponseDto.class);
    }

    public void deleteById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentRepository.delete(student);
    }
}
