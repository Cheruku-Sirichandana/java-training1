package com.SpringBootProject.ManyToManyMappingStudentsCourses.Services;


import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Courses;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Students;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.CoursesModel;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.StudentsModel;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Repository.StudentsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsServices {

    @Autowired
    private StudentsRepository srepo;

    public StudentsModel saveStudent(StudentsModel studentModel) {
        Students s = srepo.findById(studentModel.getSid()).orElse(null);
        if (s != null) {
            return null;
        }
        Students student = new Students();
        BeanUtils.copyProperties(studentModel, student);
        srepo.save(student);
        return studentModel;
    }

    public List<StudentsModel> getAllStudents() {
        List<Students> students=srepo.findAll();
        List<StudentsModel> studentList=new ArrayList<>();
        students.forEach(s->{
            StudentsModel studentModel=new StudentsModel();
            BeanUtils.copyProperties(s,studentModel);
            studentList.add(studentModel);
        });
        return studentList;
    }

    public List<CoursesModel> getAllCourses(long sid) {
        Students s = srepo.findById(sid).orElse(null);
        List<CoursesModel> courseModelList=new ArrayList<>();

        if (s != null) {
            List<Courses> coursesList = s.getCoursesList();
            coursesList.forEach(c->{
                CoursesModel courses=new CoursesModel();
                BeanUtils.copyProperties(c,courses);
                courseModelList.add(courses);
            });
        }
        return courseModelList;
    }

    public String addCourse(long sid, CoursesModel course) {
        Students s=srepo.findById(sid).orElse(null);
        if(s==null){
            return "student Id is not Registerd";
        }
        List<Courses> courseList=s.getCoursesList();
        Courses c1=new Courses();
        BeanUtils.copyProperties(course,c1);
        courseList.add(c1);
        srepo.save(s);
        return "Added Successfully";
    }

    public StudentsModel searchStudent(long sid) {
        Students s1=srepo.findById(sid).orElse(null);
        StudentsModel s=new StudentsModel();
        BeanUtils.copyProperties(s1,s);
        return s;
    }

    public String deleteStudent(long sid) {
        srepo.deleteById(sid);
        return "deleted";
    }

    public String deleteCourse(long sid) {
        List<Students> studentList=srepo.findAll();
        studentList.forEach(s-> System.out.println(s));
        studentList.forEach(student->{
            if(student.getCoursesList()!=null){
                student.getCoursesList().removeIf(course -> course.getCid()==(sid));
                srepo.save(student);

            }
        });

        return "removed";
    }

    public void deleteCourseOfStudent(long sid, long cid) {
        Students student=srepo.findById(sid).orElse(null);
        if(student.getCoursesList()!=null){
            student.getCoursesList().removeIf(course -> course.getCid()==(cid));
            srepo.save(student);
            System.out.println("course Deleted");
        }
        System.out.println("course not deleted");
    }

    public void updateStudent(StudentsModel student) {
        Students s1=srepo.findById(student.getSid()).orElse(null);
        // BeanUtils.copyProperties(student,s1);
        s1.setSname(student.getSname());
        s1.setSclass(student.getSclass());
        srepo.save(s1);
    }
}