package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Work;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInsertWork {
 public void  insertWorks(Work Student_Work);
 public List<Work>  selectWorksByStudentnameAndLessonid(Map<String, Object> map);
 public void updateWorkUpload(Work Student_Work);
 public List<Work> selectCommitStudentList(@Param("workid") int workid);
 public void updatePercent(Map<String, Object> map);
}
