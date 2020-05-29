package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Mate ;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IMate {
//添加班级
	public void addMate(Mate mate);
	//查询班级
	public List<Mate> seletMate();
	//查询班级是否存在
	public Mate selectBJCZ(Mate mate);
	//
	public Mate selectMtInfoByMateid(int id);
	//通过school，zy，bjh查询mateid
	public List<Integer> selectMateIdByMate(Mate m);
}
