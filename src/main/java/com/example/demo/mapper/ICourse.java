package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Course_teacher ;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourse {
	 Integer addCourse(Course course);
	 List<Course> selectCourse();
	 List<Course_teacher> selectMateCourse(int mateid);
}