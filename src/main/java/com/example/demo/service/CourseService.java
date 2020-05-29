package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Course_teacher;
import com.example.demo.mapper.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    @Autowired
    ICourse icourse;
   public Integer addCourse(Course course){
       return icourse.addCourse(course);
    }
   public List<Course> selectCourse(){
        return icourse.selectCourse();
    }
    public List<Course_teacher> selectMateCourse(int mateid){
        return icourse.selectMateCourse(mateid);
    }
}
