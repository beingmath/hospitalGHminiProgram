package com.example.demo.service;

import com.example.demo.entity.Mate;
import com.example.demo.mapper.IMate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateService {
    @Autowired
    IMate imate;
    //添加班级
    public void addMate(Mate mate){imate.addMate(mate);}
    //查询班级
    public List<Mate> seletMate(){
        return imate.seletMate();
    }
    //查询班级是否存在
    public Mate selectBJCZ(Mate mate){
        return imate.selectBJCZ(mate);
    }
    //
    public Mate selectMtInfoByMateid(int id){
        return imate.selectMtInfoByMateid(id);
    }
    //通过school，zy，bjh查询mateid
    public List<Integer> selectMateIdByMate(Mate m){
        return imate.selectMateIdByMate(m);
    }
}
