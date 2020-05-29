package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Lesson ;
import org.springframework.stereotype.Repository;

@Repository
public interface ILesson {
	public void insertLesson(Lesson lesson);
	public List<Lesson> selectLessonByStudentname(@Param("studentname") String studentname);
	public List<Lesson> selectLesson(String username);
	public Lesson selectLessonById(int id);
	public List<Lesson> selectLessonBySearchMsg(@Param("lessonName") String lessonName);
}
