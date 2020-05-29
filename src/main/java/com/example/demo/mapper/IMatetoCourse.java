package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatetoCourse {
   public void insertMateidCourseid(@Param("courseid") int courseid, @Param("mateids") List<Integer> mateids);
}
