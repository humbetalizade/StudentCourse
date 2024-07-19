package org.book.studentcourse.controller;

import lombok.RequiredArgsConstructor;
import org.book.studentcourse.dto.request.CourseRequestDto;
import org.book.studentcourse.dto.response.CourseResponseDto;
import org.book.studentcourse.entity.Course;
import org.book.studentcourse.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/add")
    public void addCourse(@RequestBody CourseRequestDto dto) {
        courseService.add(dto);
    }

    @GetMapping("/getall")
    public List<CourseResponseDto> getAllCourses() {
         return courseService.getAll();
    }

    @GetMapping("/getbyid{id}")
    public CourseResponseDto getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @DeleteMapping("/deletebyid{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteById(id);
    }


}
