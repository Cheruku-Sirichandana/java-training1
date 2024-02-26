package com.SpringBootProject.ManyToManyMappingStudentsCourses.Controller;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.CoursesModel;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Model.StudentsModel;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Services.CoursesServices;
import com.SpringBootProject.ManyToManyMappingStudentsCourses.Services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

@Controller
public class StudentsCoursesController {
   @Autowired
   private StudentsServices studentServices;
    @Autowired
    private CoursesServices courseServices;
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @RequestMapping("/addStudentResult")
    public String addStudentResult(StudentsModel student, ModelMap model){
        StudentsModel s=studentServices.saveStudent(student);
        model.addAttribute("student",s);
        System.out.println(s);
        return "redirect:/viewStudents";

    }
    @RequestMapping("/addCourses")
    public String addCourses(){
        return "addCourses";
    }

    @RequestMapping("/addResultCourses")
    public String addResultCourses(CoursesModel course,ModelMap model){
        CoursesModel c=courseServices.saveCourse(course);
        model.addAttribute("course",c);
        System.out.println(c);

        return "redirect:/viewCourses";
    }

    @RequestMapping("/viewStudents")
    public String viewStudents(ModelMap model){
        List<StudentsModel> studentList=studentServices.getAllStudents();
        model.addAttribute("studentsList",studentList);
        return "viewStudents";

    }
    @RequestMapping("/viewCourses")
    public String  viewCourses(ModelMap mp){
        List<CoursesModel> courseList=courseServices.getAllCourses();
        mp.addAttribute("coursesList",courseList);
        return "viewCourses";
    }
    @RequestMapping("/viewStudentCourses")
    public String viewStudentCourses(@RequestParam("sid") long sid,ModelMap model){
        List<CoursesModel> CourseList=studentServices.getAllCourses(sid);
        System.out.println(CourseList);
        model.addAttribute("coursesList",CourseList);
        model.addAttribute("sid",sid);
        return "viewStudentCourses";
    }
    @RequestMapping("/viewCoursesStudent")
    public String viewCoursesStudent(@RequestParam("cid") long cid,ModelMap mp){
        System.out.println("couses");
        List<StudentsModel> studentModelList=courseServices.getAllStudents(cid);
        //  System.out.println(studentModelList);
        mp.addAttribute("studentsList",studentModelList);
        mp.addAttribute("cid",cid);
        return "viewCoursesStudent";
    }

    @RequestMapping("/AddCoursesToStudent")
    public String AddCoursesToStudent(@RequestParam("sid") long sid,ModelMap model){
        model.addAttribute("sid",sid);
        return "AddCoursesToStudentForm";
    }
    @RequestMapping("/AddCoursesToStudentResult")
    public String AddCoursesToStudentResult(@RequestParam("sid") long sid, @RequestParam("cid") int cid, ModelMap mp){
        CoursesModel course=courseServices.searchCourse(cid);
        if(course!=null){
            String str;

            str=studentServices.addCourse(sid,course);
            System.out.println(str);
            mp.addAttribute("msg",str);

        }
        else{
            mp.addAttribute("msg","course Id is not Registered");
        }
        return "redirect:/viewStudents";
    }
    @RequestMapping("/addStudentToCourse")
    public String addStudentToCourse(@RequestParam("cid") long cid,ModelMap mp){
        mp.addAttribute("cid",cid);
        return "addStudentToCourseForm";
    }
    @RequestMapping("/addStudentToCourseResult")
    public String addStudentToCourseResult(@RequestParam("sid") long sid,@RequestParam("cid") int cid,ModelMap mp){
        StudentsModel student=studentServices.searchStudent(sid);
        CoursesModel course=courseServices.searchCourse(cid);

        // System.out.println(student);
        if(student!=null){
            String str=studentServices.addCourse(sid,course);
            //System.out.println(str);
        }
        return "redirect:/viewCourses";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("sid") long sid){
        String str=studentServices.deleteStudent(sid);
        System.out.println(str);
        return "redirect:/viewStudents";
    }
    @RequestMapping("/deleteCourseOfStudent")
    public String deleteCourseOfStudent(@RequestParam("sid") long sid,@RequestParam("cid") long cid){
        studentServices.deleteCourseOfStudent(sid,cid);
        return "redirect:viewStudents";

    }
    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("cid") long cid){
        String str=studentServices.deleteCourse(cid);
        String string=courseServices.deleteCourse(cid);
        System.out.println(str);
        return "redirect:/viewCourses";
    }
    @RequestMapping("/deleteStudentOfCourse")
    public String deleteStudentOfCourse(@RequestParam("sid") long sid,@RequestParam("cid") long cid){
        studentServices.deleteCourseOfStudent(sid,cid);

        // courseServices.deleteStudentOfCourse
        return "redirect:/viewCourses";

    }
    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("sid") long sid,ModelMap mp){
        mp.addAttribute("sid",sid);
        return "updateStudentForm";
    }
    @RequestMapping("/updateStudentResult")
    public String updateStudentResult(StudentsModel student){
        studentServices.updateStudent(student);
        return "redirect:viewStudents";
    }
    @RequestMapping("/updateCourse")
    public  String updateCourse(@RequestParam("cid") long cid, ModelMap model){
        model.addAttribute("cid",cid);
        return "updateCourseForm";
    }
    @RequestMapping("/updateCourseResult")
    public String updateCourseResult(CoursesModel courseModel){
        courseServices.updateCourse(courseModel);
        return "redirect:/viewCourses";

    }
}