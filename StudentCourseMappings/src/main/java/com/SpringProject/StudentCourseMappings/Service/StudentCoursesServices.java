package com.SpringProject.StudentCourseMappings.Service;

import com.SpringProject.StudentCourseMappings.Entity.Courses;
import com.SpringProject.StudentCourseMappings.Entity.Student;
import com.SpringProject.StudentCourseMappings.Repository.CoursesRepository;
import com.SpringProject.StudentCourseMappings.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class StudentCoursesServices {
    @Autowired
    StudentRepository srepo;
    @Autowired
    CoursesRepository crepo;

    public Student getStudentById(int sid) {
        return srepo.findById(sid).orElse(null);
    }

    public Student saveStudent(Student student) {

        return srepo.save(student);
    }

    //Course
    public Courses getCourseById(int cid) {
        return crepo.findById(cid).orElse(null);
    }

    public Courses saveCourse(Courses course) {

        return crepo.save(course);
    }

    public List<Student> getAllStudentsWithCourses() {
        return srepo.findAll(); // This will fetch Students with associated Courses
    }


    public boolean deleteStudentById(int sid) {
        if (srepo.findById(sid) == null) {
            return false;
        }
        // repository.findById(id);
        srepo.deleteById(sid);
        return true;
    }


    public Student findId(int sid) {
        return srepo.findById(sid).orElse(null);
    }

    public List<Student> findAll() {

        return srepo.findAll();

    }

    public boolean findById(int sid){
        if(srepo.findById(sid)==null){
            return false;
        }
        return true;
    }
}



