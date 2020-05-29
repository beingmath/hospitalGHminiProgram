package com.example.demo.mapper;

import com.example.demo.entity.Course;
import com.example.demo.entity.Course_teacher;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProduct {
	 List<Product> selectProducts(int parentid);
}