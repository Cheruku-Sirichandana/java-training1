package com.SpringBootProject.ManyToManyMappingStudentsCourses.Services;

import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Courses;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Students;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.CoursesModel;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.StudentsModel;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Repository.CoursesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServices {
    @Autowired
    private CoursesRepository crepo;
    public  CoursesModel saveCourse(CoursesModel courseModel) {
        Courses c=crepo.findById(courseModel.getCid()).orElse(null);
        if(c!=null){
            return null;
        }
        Courses course=new Courses();
        BeanUtils.copyProperties(courseModel,course);
        crepo.save(course);
        return courseModel;
    }

    public List<CoursesModel> getAllCourses() {
        List<Courses> coursesList=crepo.findAll();
        List<CoursesModel> courseModelList=new ArrayList<>();
        coursesList.forEach(c->{
            CoursesModel courses=new CoursesModel();
            BeanUtils.copyProperties(c,courses);
            courseModelList.add(courses);
        });
        return courseModelList;
    }

    public List<StudentsModel> getAllStudents(long cid) {
        Courses c=crepo.findById(cid).orElse(null);
        List<StudentsModel> studentList=new ArrayList<>();
        if(c!=null) {
            List<Students> students=c.getStudentsList();
            students.forEach(s -> {
                StudentsModel studentModel = new StudentsModel();
                BeanUtils.copyProperties(s, studentModel);
                studentList.add(studentModel);
            });
        }
        return studentList;
    }

    public CoursesModel searchCourse(long cid) {
        Courses courses=crepo.findById(cid).orElse(null);
        if(courses==null){
            return null;
        }
        CoursesModel courseModel=new CoursesModel();
        BeanUtils.copyProperties(courses,courseModel);
        return courseModel;
    }

    public String addStudent(long cid, StudentsModel student) {
        System.out.println(cid);
        Courses courses=crepo.findById(cid).orElse(null);
        List<Students> studentList=courses.getStudentsList();
        Students s=new Students();
        BeanUtils.copyProperties(student,s);
        studentList.add(s);
        crepo.save(courses);
        return "added Successfully";

    }

    public String deleteCourse(long cid) {
        Courses course=crepo.findById(cid).orElse(null);
        System.out.println(course);
        course.setStudentsList(null);
        crepo.save(course);
        crepo.deleteById(cid);
        return "deleted";
    }
    public void updateCourse(CoursesModel course) {

        Courses courseE = crepo.findById(course.getCid()).orElse(null);
        courseE.setCname(course.getCname());
        courseE.setCdept(course.getCdept());
        crepo.save(courseE);
    }



}
