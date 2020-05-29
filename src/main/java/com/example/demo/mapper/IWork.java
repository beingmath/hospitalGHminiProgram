package com.example.demo.mapper;
import java.util.List;
import com.example.demo.entity.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IWork {
 List<Work> selectWork(Work work);
 Integer insertWork(Work work);
 List<Work> selectWorkBylessonId(@Param("lessonid") int lessonid);
}
