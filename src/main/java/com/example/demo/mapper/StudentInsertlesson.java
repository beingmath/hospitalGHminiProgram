package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInsertlesson {
 public void StudentInsertLesson(Map<String, Object> map);
 //通过课程编号查询添加了这门课程的学生，查出这些学生的name;
 public List<String> selectStudentLessonByLessonid(@Param("lessonid") int lessonid);
}
