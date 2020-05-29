package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.mapper.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService{
    @Autowired
    IProduct iProduct;
  public  List<Product> selectProducts(){
        List<Product> productVo0= iProduct.selectProducts(0);
        for(Product pro2:productVo0){
            List<Product> productVo1=iProduct.selectProducts(pro2.getId());
            pro2.setProducts(productVo1);
        }
       return  productVo0;
    }
}
