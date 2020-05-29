package com.example.demo.control;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class DoctorControll {
    @Autowired
    DoctorService doctorService;
    @ResponseBody
    @RequestMapping({"selectdoctor","wx/selectdoctor"})
    public List<Doctor> selectDoctor(){
        return doctorService.selectDoctor();
    }


    @RequestMapping({"deleteDoctor"})
    public String deleteDoctor(@RequestParam("id") int id){
         doctorService.deleteDoctor(id);
         return "doctor";
    }

    @RequestMapping("addDoctor")
    public String addDoctor(@RequestParam("name") String name,@RequestParam("major") String major,@RequestParam("price") String price,@RequestParam("office") String office,@RequestParam("png") MultipartFile file,@RequestParam("intro") String intro) throws Exception{
        if(file.getSize()==0||price.trim().length()==0||name.trim().length()==0){
            return "doctor";
        }
     String fileName="";
       String path="target/classes/static/doctorimage";
       String path2="src/main/resources/static/doctorimage";
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
            out2.flush();//类似于文件复制，将文件存储到输入流，再通过输出流写入到上传位置
        }                               //这段代码也可以用IOUtils.copy(in, out)工具类的copy方法完成
        out.close();
        out2.close();
        in.close();
        Doctor doctor=new Doctor();
        doctor.setName(name);
        doctor.setPng(fileName);
        doctor.setPrice(Double.parseDouble(price));
        doctor.setOffice(office);
        doctor.setMajor(major);
        doctor.setIntro(intro);
        System.out.println("上传成功");
        System.out.println(fileName);
        doctorService.insertDoctor(doctor);
       return "doctor";
    }
    public Doctor selectDoctorById(){
        return null;
    }
}
