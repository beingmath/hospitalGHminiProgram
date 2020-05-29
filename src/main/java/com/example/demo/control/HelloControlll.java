package com.example.demo.control;

import com.example.demo.entity.*;
import com.example.demo.service.ProductService;
import com.example.demo.service.RecordService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloControlll {
    @Autowired
    RecordService  recordService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
//    @ResponseBody
//    @RequestMapping("hel")
//    public String hel(){
//        return "hello world!";
//    }

    @ResponseBody
    @RequestMapping("wx/login")
    public String  login(@RequestParam("code") String code) throws Exception{
        Map<String, String> param = new HashMap<String, String>();
        param.put("appid",Mini.AppId);
        param.put("secret",Mini.AppSecret);
        param.put("js_code",code);
        param.put("grant_type",Mini.GRANT_TYPE);
        String wxResult =HttpClientUtil.doGet(Mini.URL, param) ;
        JSONObject so=JSON.parseObject(wxResult);
       String openid=so.get("openid").toString();
        System.out.println("openid:  "+openid);
        String session_key=so.get("session_key").toString();
       return openid;
    }
//    @RequestMapping("hedge")
//    public String hePage(){
//        return "hello";http:localhost:8000/selectMenu
     @ResponseBody
    @RequestMapping({"saveRecord","wx/saveRecord"})
    public void saveRecord(@RequestParam("openid") String openid,@RequestParam("record") String record){

         JSONObject so=JSON.parseObject(record);
      // Doctor o=  (Doctor) so.get("doctor");
         JSONObject o=  (JSONObject) so.get("doctor");
         Doctor doctor=  (Doctor)o.toJavaObject(Doctor.class);
         System.out.println(doctor.toString());
     // public Record(String openid, Doctor doctor, String patientName, String phone, String birth, String time) {
         Record re=new Record(openid,doctor,so.get("patientName").toString(),so.get("phone").toString(),so.get("birth").toString(),so.get("time").toString());
         re.setDoctorid(doctor.getId());
         recordService.insertRecord(re);

    }
    @ResponseBody
    @RequestMapping({"selectRecord","wx/selectRecord"})
    public List<Record> selectRecord(@RequestParam("openid") String openid){
      return  recordService.selectRecord(openid);
    }

    @ResponseBody
    @RequestMapping("wx/deleteRecord")
    public void deleteRecord(@RequestParam("id") int id){
       recordService.deleteRecord(id);
    }
    @ResponseBody
    @RequestMapping("selectAllRecord")
    public List<Record> selectAllRecord(){
        return  recordService.selectAllRecord();
    }
   }

