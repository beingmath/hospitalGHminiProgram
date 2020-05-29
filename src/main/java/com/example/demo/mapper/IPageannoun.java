package com.example.demo.mapper;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Pageannoun;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPageannoun {

	public void addPageannoun(Pageannoun Pageannoun);
	public List<Pageannoun> selectPageannoun();
	public void deletePageannoun(int id);
}