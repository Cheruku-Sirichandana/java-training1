package com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Students {
    @Id
    private long sid;
    private String sname;
    private String sclass;
    @ManyToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    private List<Courses> CoursesList=new ArrayList<>();

    public Students() {
    }

    public Students(long sid, String sname, String sclass, List<Courses> coursesList) {
        this.sid = sid;
        this.sname = sname;
        this.sclass = sclass;
        CoursesList = coursesList;
    }

    public Students(long sid) {
        this.sid = sid;
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
}
