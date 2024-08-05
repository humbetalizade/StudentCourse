package org.book.studentcourse.repository;

import org.book.studentcourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
