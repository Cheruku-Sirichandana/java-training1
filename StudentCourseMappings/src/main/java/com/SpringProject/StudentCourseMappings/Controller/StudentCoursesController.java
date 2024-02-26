package com.SpringProject.StudentCourseMappings.Controller;

import com.SpringProject.StudentCourseMappings.Entity.Courses;
import com.SpringProject.StudentCourseMappings.Entity.Student;
import com.SpringProject.StudentCourseMappings.Service.StudentCoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentCoursesController {
    @Autowired
    StudentCoursesServices services;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/student")
    public String student() {
        return "student";
    }

    @RequestMapping("/courses")
    public String courses() {
        return "courses";
    }
//Student Operations
@RequestMapping("/addStudent")
public String addStudent() {
    return "addStudent";
}

    @RequestMapping("/addedStudent")
    public String addedStudent(@RequestParam("sid") int sid, ModelMap model) {
        System.out.println("ghdvjdhs......");
        Student student= services.getStudentById(sid);
        model.addAttribute("addStudent", student);
        return "addedStudent";
    }

    @RequestMapping("/addStudentDone")
    public String addStudentDone(int sid,String sname,String srollno,String sclass,int cid,String cname,String cdept, ModelMap model) {
        System.out.println("dbsbdnmsa..");

        Courses course=new Courses(cid,cname,cdept,null);
        Student student=new Student(sid,sname,srollno,sclass,course);
        Student studentx = services.saveStudent(student);
        model.addAttribute("addStudent", studentx);
        return "home";
    }



//Deletion
    @RequestMapping("/deleteStudent")
    public String deleteStudent(ModelMap model) {
        System.out.println("deleting....");
        return "deleteStudent";
    }

    @RequestMapping("/deleteStudentDone")
    public String deleteStudentDone(@RequestParam("sid") int sid, Model model) {
        if (services.getStudentById(sid) != null) {
            model.addAttribute("student", services.getStudentById(sid));

        }
        System.out.println(".....................");
        boolean deletedStudent = services.deleteStudentById(sid);
        model.addAttribute("deletedStudent", deletedStudent);
        return "deleteStudentDone";
    }

    @RequestMapping("/deleteStudentSuccess")
    public String deleteStudentSuccess() {
        return "home";
    }

    //Viewing
    @RequestMapping("/viewStudents")
    public String viewStudents(Model m) {
        List<Student> studentList = services.findAll();
        System.out.println("ALLLLLLLLLLLLLLLLLL");
        // m.addAttribute("viewEmployees",employeeList);
        //return "viewEmployees";
        m.addAttribute("viewStudents", studentList);
        System.out.println(studentList);
        return "viewStudents";

    }


    //update
    @RequestMapping("/updateStudent")
    public String updateStudent(){
        return "updateStudent";
    }
    @RequestMapping("/updateStudentDone")
    public String updateStudentDone(@RequestParam("sid") int sid,Model model){
        Student student=services.findId(sid);
        model.addAttribute("updateStudent", student);
        model.addAttribute("sid",sid);
        return "updateStudentDone";

    }
    @RequestMapping("/updateStudentSuccessfully")
    public String updateStudentSuccessfully(int sid,String sname,String srollno,String sclass,int cid,String cname,String cdept){

        Courses course=new Courses(cid,cname,cdept,null);
        Student student=new Student(sid,sname,srollno,sclass,course);
        Student studentx = services.saveStudent(student);
        System.out.println(student);
        services.saveStudent(student);
        return "home";
    }
//search

    @RequestMapping("/searchStudent")
    public String searchStudent() {
        return "searchStudent";
    }

    @RequestMapping("/searchStudentDone")
    public String searchStudentDone(@RequestParam("sid") int sid, ModelMap model) {

        boolean searchedStudent = services.findById(sid);
        if (searchedStudent) {
            System.out.println("dhshjjllllllllll.....");
            Student student= services.findId(sid);
            model.addAttribute("searchStudent", student);


            // model.getAttribute("searchEmployee",service.findById(id));
            return "searchStudentDone";

        }
        return null;


    }
}





