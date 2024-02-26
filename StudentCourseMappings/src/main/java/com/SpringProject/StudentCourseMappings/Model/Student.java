package com.SpringProject.StudentCourseMappings.Model;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int sid;
    private String sname;
    private String srollno;
    private String sclass;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSrollno() {
        return srollno;
    }

    public void setSrollno(String srollno) {
        this.srollno = srollno;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public Student(int sid, String sname, String srollno, String sclass) {
        this.sid = sid;
        this.sname = sname;
        this.srollno = srollno;
        this.sclass = sclass;
    }


    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", srollno='" + srollno + '\'' +
                ", sclass='" + sclass + '\'' +
                '}';
    }
}
