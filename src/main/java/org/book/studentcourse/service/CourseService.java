package org.book.studentcourse.service;

import lombok.RequiredArgsConstructor;
import org.book.studentcourse.dto.request.CourseRequestDto;
import org.book.studentcourse.dto.response.CourseResponseDto;
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
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    public void add(CourseRequestDto courseRequestDto) {
        Course course2 = modelMapper.map(courseRequestDto, Course.class);
        List<Long>studentIds= Collections.singletonList(courseRequestDto.getStudentId());
        List<Student> students = new ArrayList<>();
        for(Long id : studentIds){
            Student student = studentRepository.findById(id).orElseThrow();
            students.add(student);
        }
        course2.setStudents(students);
        courseRepository.save(course2);
    }


    public List<CourseResponseDto> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(item -> modelMapper.map(item, CourseResponseDto.class))
                .collect(Collectors.toList());
    }

    public CourseResponseDto findById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return modelMapper.map(course, CourseResponseDto.class);
    }

    public void deleteById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        courseRepository.delete(course);
    }
}