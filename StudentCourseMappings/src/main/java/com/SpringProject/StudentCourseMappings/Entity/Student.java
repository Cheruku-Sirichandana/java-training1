package com.SpringProject.StudentCourseMappings.Entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;
    private String sname;
    private String srollno;
    private String sclass;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Courses courses;

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




