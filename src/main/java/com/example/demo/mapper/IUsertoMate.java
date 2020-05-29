package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.UsertoMate;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsertoMate {
 public void insertUsertoMate(List<UsertoMate> UsertoMate);


public void deleteUsertoMate(@Param("mateid") int mateid, @Param("userids") List<String> userids);
}
