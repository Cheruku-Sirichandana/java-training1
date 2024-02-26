package com.example.MappingOneToMany.Repository;

import com.example.MappingOneToMany.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<Courses,Integer> {
}
