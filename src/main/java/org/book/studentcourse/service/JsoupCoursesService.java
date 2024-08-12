package org.book.studentcourse.service;

import org.book.studentcourse.entity.Course;
import org.book.studentcourse.entity.Student;
import org.book.studentcourse.repository.CourseRepository;
import org.book.studentcourse.repository.StudentRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class JsoupCoursesService {
    private final CourseRepository courseRepository;

    public JsoupCoursesService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Scheduled(fixedRate = 10000)
    public void getBooks() throws IOException {

        // List<Course> courses = new ArrayList<>();

        int pageNumber = 1;
        while (pageNumber < 3) {
            Document document = Jsoup.connect("https://kurslar.az/it-komputer-kurslari/?start=" + pageNumber).get();
            Elements elementsByClass = document.getElementsByClass("nobj prod prodbig");

            for (Element element : elementsByClass) {
                Course course=new Course();
                String prodname = element.getElementsByClass("prodname").text();
                System.out.println(prodname);
//                courses.add(new Course(elementByClass.text()));
                course.setName(prodname);
                courseRepository.save(course);
            }

            pageNumber++;
        }
    }

}
