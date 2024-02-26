package com.SpringBootProject.ManyToManyMappingStudentsCourses.Repository;

import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository  extends JpaRepository<Students,Long> {

    }

