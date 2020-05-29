package com.example.demo.mapper;

import com.example.demo.entity.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecord {

	public List<Record> selectRecord(String openid);
	 public void insertRecord(Record record);
	 public void deleteRecord(int id);
	 public List<Record> selectAllRecord();
}