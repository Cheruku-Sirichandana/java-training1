package com.SpringProject.StudentCourseMappings.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;//course id
    private String cname;//course name
    private String cdept;//course department

    @OneToOne(mappedBy="courses")
    @JsonBackReference
    private Student student;

    @Override
    public String toString() {
        return "Courses{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdept='" + cdept + '\'' +
                '}';
    }
}
