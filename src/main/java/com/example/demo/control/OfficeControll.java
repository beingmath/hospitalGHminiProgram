package com.example.demo.control;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import com.example.demo.entity.Office;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import  java.util.List;
@Controller
public class OfficeControll {
    @Autowired
    OfficeService officeService;
    @ResponseBody
    @RequestMapping({"selectOffice","wx/selectOffice"})
    public List<Office> selectOffice(){
        return officeService.selectOffice();
    }
    @ResponseBody
    @RequestMapping({"selectOfficeNameNoRepeat","wx/selectOfficeNameNoRepeat"})
    public List<String> selectOfficeNameNoRepeat(){
        return officeService.selectOfficeNameNoRepeat();
    }


    @RequestMapping("deleteOffice")
    public String deleteOffice(@RequestParam("id") int id){
        officeService.deleteOffice(id);
        return "office";
    }
    @RequestMapping("addOffice")
    public String addOffice(@RequestParam("name") String name,@RequestParam("png") MultipartFile file) throws Exception{
        if(file.getSize()==0||name.trim().length()==0){
            return "office";
        }
     String fileName="";
       String path="target/classes/static/officeimage";
       String path2="src/main/resources/static/officeimage";
        File  file1 = new File(path);
        File  file2 = new File(path2);
        if(!file1.exists()){
            file1.mkdir();   //如果该目录不存在，就创建此抽象路径名指定的目录。
        }
        if(!file2.exists()){
            file2.mkdir();   //如果该目录不存在，就创建此抽象路径名指定的目录。
        }
        fileName =file.getOriginalFilename();//使用UUID加前缀命名文件，防止名字重复被覆盖
        String prefix = UUID.randomUUID().toString();
        prefix = prefix.replace("-","");
        fileName = prefix+"_"+file.getOriginalFilename();
        InputStream in= file.getInputStream();;//声明输入输出流
        OutputStream out=new FileOutputStream(new File(path+"\\"+fileName));//指定输出流的位置;

        OutputStream out2=new FileOutputStream(new File(path2+"\\"+fileName));//指定输出流的位置;
        byte []buffer =new byte[1024];
        int len=-1;
        while((len=in.read(buffer))!=-1){
            out.write(buffer, 0, len);
            out2.write(buffer, 0, len);
            out.flush();
            out2.flush();
        }
        out.close();
        out2.close();
        in.close();
        Office office=new Office();
        office.setName(name);
        office.setPng(fileName);
        System.out.println("上传成功");
        System.out.println(fileName);
        officeService.insertOffice(office);
       return "office";
    }
}
