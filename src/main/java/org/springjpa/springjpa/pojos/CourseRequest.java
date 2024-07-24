package org.springjpa.springjpa.pojos;

import org.springjpa.springjpa.entities.Content;

import java.util.Set;

public class CourseRequest {
    public int id;
    public String courseName;
    public Set<Content> contents;
}
