package com.example.demo.service;

import com.example.demo.mapper.IMatetoCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatetoCourseService {
    @Autowired
    IMatetoCourse iMatetoCourse;
    public void insertMateidCourseid(int courseid,List<Integer> mateids){
        iMatetoCourse.insertMateidCourseid(courseid,mateids);
    }
}
