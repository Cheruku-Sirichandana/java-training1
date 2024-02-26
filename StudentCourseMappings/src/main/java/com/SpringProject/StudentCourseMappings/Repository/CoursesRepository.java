package com.SpringProject.StudentCourseMappings.Repository;

import com.SpringProject.StudentCourseMappings.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
}
