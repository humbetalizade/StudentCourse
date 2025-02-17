package org.book.studentcourse.service;

import lombok.RequiredArgsConstructor;
import org.book.studentcourse.dto.request.CourseRequestDto;
import org.book.studentcourse.dto.response.CourseResponseDto;
import org.book.studentcourse.entity.Course;
import org.book.studentcourse.repository.CourseRepository;
import org.book.studentcourse.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public void add(CourseRequestDto courseRequestDto) {
        Course course = modelMapper.map(courseRequestDto, Course.class);
        courseRepository.save(course);
    }


    @Scheduled(fixedRate = 10000)
    public List<CourseResponseDto> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(item -> modelMapper.map(item, CourseResponseDto.class))
                .toList();
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
