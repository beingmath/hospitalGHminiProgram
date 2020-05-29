package com.example.demo.service;

import com.example.demo.entity.Office;
import com.example.demo.entity.Doctor;
import com.example.demo.mapper.IDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctor Idoctor;
   public void deleteDoctor(int id){
   Idoctor.deleteDoctor(id);
   }
    public List<Doctor> selectDoctor(){
        return Idoctor.selectDoctor();
    }
    public void insertDoctor(Doctor doctor){
        Idoctor.insertDoctor(doctor);
    }
    public Doctor selectDoctorById(int id){
return null;
    }
}
