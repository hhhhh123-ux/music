package com.javaclimb.music.controller;

import com.javaclimb.music.utils.FileUtils;
import org.slf4j.Logger;
import com.alibaba.fastjson.JSONObject;
import com.javaclimb.music.domain.Singer;
import com.javaclimb.music.service.SingerService;
import com.javaclimb.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.util.calendar.LocalGregorianCalendar;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @RequestMapping("add")
    public Object addSinger(HttpServletRequest request, Singer singer){
        JSONObject jsonObject=new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowdayTime = dateFormat.format(singer.getBirth());
        Date date=new Date();
        try {
            date=dateFormat.parse(nowdayTime);
        }catch (ParseException e){
            e.printStackTrace();
        }
        singer.setBirth(date);
        boolean flag=singerService.insert(singer);
        if(flag){
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
    }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }
    @RequestMapping("selectname")
    public Object selectname(HttpServletRequest request, Singer singer){
        List<Singer> singers=singerService.selectname(singer.getName());
        return singers;
    }

    @RequestMapping("update")
    public Object update(HttpServletRequest request, Singer singer){
        JSONObject jsonObject=new JSONObject();
       boolean flag=singerService.update(singer);
       if(flag){
           jsonObject.put(Consts.CODE, 1);
           jsonObject.put(Consts.MSG,"修改成功");
           return jsonObject;
       }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public Object delete(HttpServletRequest request, Singer singer){
        JSONObject jsonObject=new JSONObject();
        boolean flag=singerService.delete(singer.getId());
        if(flag){
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG,"修改失败");
        return flag;
    }
    @RequestMapping(value = "allSinger",method = RequestMethod.GET)
    public Object allSinger(HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String nowdayTime = dateFormat.format(singer.getBirth());
//        Date date=new Date();

        List<Singer> singers=singerService.allselect();

        return singers;
    }
    @RequestMapping(value = "/updateSingerPic",method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
            return jsonObject;
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"singerPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/singerPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storeAvatorPath);
            boolean flag = singerService.update(singer);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("pic",storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
        }finally {
            return jsonObject;
        }
    }
@RequestMapping(value = "/updatePic",method = RequestMethod.POST)
public Object updatePic(@RequestParam("file") MultipartFile multipartFile, int id){
        JSONObject jsonObject=new JSONObject();
      if(multipartFile.isEmpty()){
       jsonObject.put(Consts.CODE,0);
       jsonObject.put(Consts.MSG,"失败");
       return jsonObject;
   }

    String filename=multipartFile.getOriginalFilename();
      //文件路径
    String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
            +System.getProperty("file.separator")+"singerPic";
    File file=new File(filePath);
    if(!file.exists()){
        file.mkdir();
    }

    File dest=new File(filePath+System.getProperty("file.separator")+filename);
     String path="/img/singerPic/"+filename;
     try{
         multipartFile.transferTo(dest);
         Singer singer=new Singer();
         singer.setId(id);
         singer.setPic(path);
        boolean flag= singerService.update(singer);
        System.out.println(flag);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"成功");
            jsonObject.put("pic",path);
        }else {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "上传失败");
        }
     }catch (Exception e){
         jsonObject.put(Consts.CODE,0);
         jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
     }finally {
         return jsonObject;
     }


}


    @RequestMapping(value = "/updatePicc",method = RequestMethod.POST)
    public Object filePic(@RequestParam("file") MultipartFile files[]){

        String filename="";
        try{
           if(files!=null){
              for(int i=0;i<files.length;i++){
                  if(!files[i].isEmpty()){
                   //filename+=FileUtils.upload()+",";
                   System.out.println(filename);
                  }
              }
           }



        }catch (Exception e){
            return    "";
        }


        return "";
    }

    @PutMapping("/multipleImageUpload")
    public List multipleImageUpload(@RequestParam("file") MultipartFile[] files){
        System.out.println("上传的图片数："+files.length);

        List<Map<String,Object>> root=new ArrayList<Map<String,Object>>();

        for (MultipartFile file : files) {    //循环保存文件

            Map<String,Object> result=new HashMap<String, Object>();//一个文件上传的结果
            String result_msg="";//上传结果信息

            if (file.getSize() / 1000 > 100){
                result_msg="图片大小不能超过100KB";
            }
            else{
                //判断上传文件格式
                String fileType = file.getContentType();
                if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                    // 要上传的目标文件存放的绝对路径
                    final String localPath="E:\\music\\music-server\\img\\singerPic";
                    //final String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                            //+System.getProperty("file.separator")+"singerPic";
                    //上传后保存的文件名(需要防止图片重名导致的文件覆盖)
                    //获取文件名
                    String fileName = file.getOriginalFilename();
                    //获取文件后缀名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    //重新生成文件名
                    fileName = UUID.randomUUID()+suffixName;
                    if (FileUtils.upload(file, localPath, fileName)) {
                        //文件存放的相对路径(一般存放在数据库用于img标签的src)
                        String relativePath="img/"+fileName;
                        result.put("relativePath",relativePath);//前端根据是否存在该字段来判断上传是否成功
                        result_msg="图片上传成功";
                    }
                    else{
                        result_msg="图片上传失败";
                    }
                }
                else{
                    result_msg="图片格式不正确";
                }
            }
            result.put("result_msg",result_msg);
            root.add(result);
        }
        String root_json=JSONObject.toJSONString(root);
        System.out.println(root_json);
        return root;
    }


}
