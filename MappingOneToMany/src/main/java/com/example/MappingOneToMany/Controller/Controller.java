package com.example.MappingOneToMany.Controller;

import com.example.MappingOneToMany.Entity.Courses;
import com.example.MappingOneToMany.Entity.Student;
import com.example.MappingOneToMany.Services.courseServices;
import com.example.MappingOneToMany.Services.studentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private studentServices services;
    @Autowired
    private courseServices servicec;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }

    @RequestMapping("/addStudentResult")
    public String addStudentResult(Student s, ModelMap mp){
        Student student=services.addStudent(s);
        mp.addAttribute("student",student);
        return "addStudentResult";
    }
    @RequestMapping("/addCourses")
    public String addCourses(){
        return "addCourses";
    }
    @RequestMapping("/addResultCourses")
    public String addResultCourses(Courses course,ModelMap mp){
        Courses c1=servicec.addCourse(course);
        //System.out.println(c1);
        if(c1!=null){
            boolean is =services.addCourse(c1);
            System.out.println(is);
        }
        //System.out.println(c1);
        mp.addAttribute("course",c1);
        return "addResultCourses";
    }
    @RequestMapping("/viewDetails")
    public String viewDetails(ModelMap mp){
        List<Student> studentList=services.getStudents();
        mp.addAttribute("studentList",studentList);
        return "viewDetails";

    }
    @RequestMapping("/viewCourses")
    public String viewCourses(@RequestParam("id") int id,ModelMap mp){
        List<Courses> coursesList=services.getCourses(id);
        mp.addAttribute("coursesList",coursesList);
        return "viewCourses";

    }
    @RequestMapping("/searchStudent")
    public String searchStudent(){
        return "searchStudent";
    }
    @RequestMapping("/searchResult")
    public String searchResult(@RequestParam("id") int id,ModelMap mp){
        Student s1=services.getStudent(id);
        mp.addAttribute("student",s1);
        return "searchResult";

    }
    @RequestMapping("/deleteStudent")
    public String DeleteStudent(@RequestParam("id") int id,ModelMap mp){
        Student s1=services.deleteStudent(id);
        mp.addAttribute("student",s1);
        return "deleteStudent";

    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("id") int id,ModelMap mp){
        List<Courses> coursesList=services.getCourses(id);
        mp.addAttribute("coursesList",coursesList);

        mp.addAttribute("id",id);
        return "viewCourses";
    }
    @RequestMapping("/deleteCourseDone")
    public String deleteCourseDone(@RequestParam("CourseId") int id,ModelMap mp){
        Courses c1=servicec.deleteCourse(id);
        System.out.println(c1);
        mp.addAttribute("course",c1);
        return "deleteCourseDone";

    }
    @RequestMapping("/update")
    public String update(){
        return "update";
    }
}
