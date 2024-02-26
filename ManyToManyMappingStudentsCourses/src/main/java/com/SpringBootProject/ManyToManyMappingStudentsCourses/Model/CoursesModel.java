package com.SpringBootProject.ManyToManyMappingStudentsCourses.Model;

import com.SpringBootProject.ManyToManyMappingStudentsCourses.Entity.Students;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CoursesModel {
    private long cid;
    private String cname;
    private String cdept;
    private List<Students> StudentsList=new ArrayList<>();

    public CoursesModel(long cid, String cname, String cdept, List<Students> studentsList) {
        this.cid = cid;
        this.cname = cname;
        this.cdept = cdept;
        StudentsList = studentsList;
    }

    public CoursesModel() {
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

    @Override
    public String toString() {
        return "CoursesModel{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdept='" + cdept + '\'' +
                ", StudentsList=" + StudentsList +
                '}';
    }
}
