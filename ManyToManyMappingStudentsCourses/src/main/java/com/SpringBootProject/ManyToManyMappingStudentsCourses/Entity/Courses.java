package com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Courses {
    @Id
    private long cid;
    private String cname;
    private String cdept;
    @ManyToMany(mappedBy = "CoursesList",fetch = FetchType.EAGER)
    private List<Students> StudentsList=new ArrayList<>();

    public Courses(long cid, String cname, String cdept, List<Students> studentsList) {
        this.cid = cid;
        this.cname = cname;
        this.cdept = cdept;
        StudentsList = studentsList;
    }

    public Courses() {
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdept() {
        return cdept;
    }

    public void setCdept(String cdept) {
        this.cdept = cdept;
    }

    public List<Students> getStudentsList() {
        return StudentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        StudentsList = studentsList;
    }
}
