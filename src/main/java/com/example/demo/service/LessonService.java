package com.example.demo.service;

import com.example.demo.entity.Lesson;
import com.example.demo.mapper.ILesson;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LessonService {
    @Autowired
    ILesson ilesson;
    public void insertLesson(Lesson lesson){
        ilesson.insertLesson(lesson);
    }
    public List<Lesson> selectLessonByStudentname(String studentname){
        return ilesson.selectLessonByStudentname(studentname);
    }
    public List<Lesson> selectLesson(String username){
        return ilesson.selectLesson(username);
    }
    public Lesson selectLessonById(int id){
        return ilesson.selectLessonById(id);
    }
    public List<Lesson> selectLessonBySearchMsg(String lessonName){
        return ilesson.selectLessonBySearchMsg(lessonName);
    }
}
