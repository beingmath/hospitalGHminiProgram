package com.example.demo.service;

import com.example.demo.entity.Record;
import com.example.demo.mapper.IRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordService {
    @Autowired
    IRecord iRecord;

    public List<Record> selectRecord(String openid){

      return  iRecord.selectRecord(openid);
    }

    public void insertRecord(Record record){
        iRecord.insertRecord(record);
    }

    public void deleteRecord(int id){iRecord.deleteRecord(id);}
    public List<Record> selectAllRecord(){
        return iRecord.selectAllRecord();
    }
}
