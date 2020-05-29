package com.example.demo.service;

import com.example.demo.entity.UsertoMate;
import com.example.demo.mapper.IUsertoMate;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsertoMateService {
    @Autowired
    IUsertoMate iusertomate;
    public void insertUsertoMate(List<UsertoMate> UsertoMate){
        iusertomate.insertUsertoMate(UsertoMate);
    }

    public void deleteUsertoMate(@Param("mateid") int mateid, @Param("userids") List<String> userids){
      iusertomate.deleteUsertoMate(mateid,userids);
    }
}
