package com.SpringBootProject.ManyToManyMappingStudentsCourses.Model;

import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Courses;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentsModel {
    private long sid;
    private String sname;
    private String sclass;
    private List<Courses> CoursesList=new ArrayList<>();

    public StudentsModel(long sid, String sname, String sclass, List<Courses> coursesList) {
        this.sid = sid;
        this.sname = sname;
        this.sclass = sclass;
        CoursesList = coursesList;
    }

    public StudentsModel() {
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public List<Courses> getCoursesList() {
        return CoursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        CoursesList = coursesList;
    }

    @Override
    public String toString() {
        return "StudentsModel{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sclass='" + sclass + '\'' +
                ", CoursesList=" + CoursesList +
                '}';
    }
}
