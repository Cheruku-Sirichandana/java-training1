package com.SpringProject.StudentCourseMappings.Model;

import org.springframework.stereotype.Component;

@Component
public class Courses {
    private int cid;//course id
    private String cname;//course name
    private String cdept;//course department

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
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

    public Courses(int cid, String cname, String cdept) {
        this.cid = cid;
        this.cname = cname;
        this.cdept = cdept;
    }

    public Courses() {
    }

    @Override
    public String toString() {
        return "Courses{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdept='" + cdept + '\'' +
                '}';
    }
}
