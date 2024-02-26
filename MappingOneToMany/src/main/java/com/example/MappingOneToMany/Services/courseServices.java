package com.example.MappingOneToMany.Services;

import com.example.MappingOneToMany.Entity.Courses;
import com.example.MappingOneToMany.Repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseServices {
    @Autowired
    private courseRepository courseRepo;

    public Courses addCourse(Courses course) {
        Courses c=courseRepo.findById(course.getCourseId()).orElse(null);
        if (c == null) {
            return courseRepo.save(course);
        }
        return null;
    }

    public Courses deleteCourse(int id) {
        Courses c=courseRepo.findById(id).orElse(null);
        if(c!=null){
            c.setStudent(null);
            courseRepo.save(c);
            courseRepo.deleteById(id);
            return c;
        }
        return null;
    }
}
