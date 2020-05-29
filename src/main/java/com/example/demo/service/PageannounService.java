package com.example.demo.service;
import com.example.demo.entity.*;
import com.example.demo.mapper.IPageannoun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageannounService {
    @Autowired
    IPageannoun Ipageannoun;

    public void addPageannoun(Pageannoun Pageannoun){
        Ipageannoun.addPageannoun(Pageannoun);
    }
   public void deletePageannoun(int id){Ipageannoun.deletePageannoun(id);}
    public List<Pageannoun> selectPageannoun(){
return Ipageannoun.selectPageannoun();
    }
}
