package org.springjpa.springjpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springjpa.springjpa.entities.Content;
import org.springjpa.springjpa.entities.Course;
import org.springjpa.springjpa.pojos.CourseRequest;
import org.springjpa.springjpa.repositories.ContentRepository;
import org.springjpa.springjpa.repositories.CourseRepository;

import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ContentRepository contentRepository;

    public CourseService(){}

    public Course addCourseWithContents(CourseRequest courseRequest){
        Course course = new Course();
        course.setId(courseRequest.id);
        course.setCourseName(courseRequest.courseName);
        course.setContents(courseRequest.contents.stream().map(content -> {
            Content ccontents = content;
            if(ccontents.getId() > 0){
                ccontents = contentRepository.findById(ccontents.getId());
            }
            ccontents.addCourse(course);
            return ccontents;
        }).collect(Collectors.toSet()));
        return courseRepository.save(course);
    }
}
