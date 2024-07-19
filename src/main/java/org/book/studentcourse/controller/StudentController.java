package org.book.studentcourse.controller;


import lombok.RequiredArgsConstructor;
import org.book.studentcourse.dto.request.StudentRequestDto;
import org.book.studentcourse.dto.response.CourseResponseDto;
import org.book.studentcourse.dto.response.StudentResponseDto;
import org.book.studentcourse.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @PostMapping("/add")
    public void create(@RequestBody StudentRequestDto studentRequestDto) {
        studentService.createStudent(studentRequestDto);
    }

    @GetMapping("/getall")
    public List<StudentResponseDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getbyid{id}")
    public StudentResponseDto getCourseById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/deletebyid{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return "Deleted student";
    }
}