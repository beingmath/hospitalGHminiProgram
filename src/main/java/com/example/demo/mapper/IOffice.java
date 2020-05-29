package com.example.demo.mapper;
import com.example.demo.entity.Office;
import com.example.demo.entity.Course;
import com.example.demo.entity.Course_teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOffice {
    public void deleteOffice(int id);
	public List<Office> selectOffice();
	 public void insertOffice(Office office);
	public List<String> selectOfficeNameNoRepeat();
}