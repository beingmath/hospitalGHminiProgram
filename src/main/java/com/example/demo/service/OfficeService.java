package com.example.demo.service;

import com.example.demo.entity.Office;
import com.example.demo.mapper.IOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import  java.util.List;
@Service
public class OfficeService {
    @Autowired
    IOffice IOffice;
   public void deleteOffice(int id){IOffice.deleteOffice(id);}
    public List<Office> selectOffice(){
        return IOffice.selectOffice();
    }
    public void insertOffice(Office office){
        IOffice.insertOffice(office);
    }
    public List<String>  selectOfficeNameNoRepeat(){
        return IOffice.selectOfficeNameNoRepeat();
    }
}
