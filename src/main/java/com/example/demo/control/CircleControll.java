package com.example.demo.control;

import com.example.demo.entity.Doctor;
import com.example.demo.service.PageannounService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.Pageannoun;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import java.util.List;
@Controller
public class CircleControll {

    @Autowired
    PageannounService pageannounService;
    @RequestMapping({"addPageannoun","wx/addPageannoun"})
    public String addPageannoun(@RequestParam("png") MultipartFile file, @RequestParam("details") String details) throws Exception{
        if(file.getSize()==0||details.trim().length()==0){
            return "circle";
        }
        String fileName="";
        String path="target/classes/static/circleimage";
        String path2="src/main/resources/static/circleimage";
        File file1 = new File(path);
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
        Pageannoun pb=new Pageannoun();
        pb.setDetails(details);
        pb.setPng(fileName);
        pageannounService.addPageannoun(pb);
        return  "circle";
    }
    @ResponseBody
    @RequestMapping({"selectPageannoun","wx/selectPageannoun"})
    public List<Pageannoun> selectPageannoun(){
        return pageannounService.selectPageannoun();
    }

    @RequestMapping("deletePageannoun")
    public String deleteRecord(@RequestParam("id") int id){
        pageannounService.deletePageannoun(id);
        return "circle";
    }
}
