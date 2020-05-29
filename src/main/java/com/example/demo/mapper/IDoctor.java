package com.example.demo.mapper;
import com.example.demo.entity.Office;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Doctor;

import java.util.List;

@Repository
public interface IDoctor {
public void deleteDoctor(int id);
	public List<Doctor> selectDoctor();
	 public void insertDoctor(Doctor Doctor);
}