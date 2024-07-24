package org.springjpa.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springjpa.springjpa.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    public Course findById(int id);
}
