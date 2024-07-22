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

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;

    public void createStudent(StudentRequestDto studentRequestDto) {
        Set<Course> courses = new HashSet<>();
        for (Long courseId : studentRequestDto.getCourseIds()){
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
            courses.add(course);
        }

        Student student = modelMapper.map(studentRequestDto, Student.class);
        student.setCourses(courses);

        studentRepository.save(student);

    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(item->modelMapper.map(item,StudentResponseDto.class))
                .toList();
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
