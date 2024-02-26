package com.example.MappingOneToMany.Repository;

import com.example.MappingOneToMany.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student,Integer> {
}
