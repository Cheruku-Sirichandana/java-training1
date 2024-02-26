package com.SpringBootProject.ManyToManyMappingStudentsCourses.Repository;

import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {

}
