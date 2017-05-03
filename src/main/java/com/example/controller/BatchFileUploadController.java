package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BatchFileUploadController {
    protected static Logger logger= LoggerFactory.getLogger(BatchFileUploadController.class);

    @Autowired
    public MultipartConfigElement multipartConfigElement;

    @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> handleFileUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if(files.isEmpty()){
            jsonMap.put("status", -1);
            jsonMap.put("result", "【文件为空！】");
            System.out.println("【文件为空！】");
        }
        for (int i =0; i< files.size(); ++i) {
            MultipartFile file = files.get(i);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddsss");
            Timestamp time = new Timestamp(new Date().getTime());
            String name = file.getName()+"time";
            if (!file.isEmpty()) {
                try {
                    String fileName=file.getOriginalFilename();
                    String uploadPath="/data/guanqian-8080/"+"filemanager";
                    System.out.println("上传路径========================"+uploadPath);
                    File uploadDir=new File(uploadPath);
                    if(!uploadDir.exists()){
                        uploadDir.mkdirs();
                    }
                    File uploadFile=new File(uploadPath+"/"+fileName);
                    logger.info("上传文件：uploadFile{}",uploadFile);
                    file.transferTo(uploadFile);//上传
                    jsonMap.put("status", 1);
                    jsonMap.put("result", name+"【上传成功！】");
                } catch (Exception e) {
                    jsonMap.put(name,"You failed to upload " + name + " => " + e.getMessage());
                    return  jsonMap;
                }
            } else {
                jsonMap.put(name,"You failed to upload " + name + " because the file was empty.");
                return jsonMap;
            }
        }
        return jsonMap;
    }

    /**
     * 获取图片给前端（注：ajax不能异步请求文件下载！！！！！）
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/showfile")
    @ResponseBody
    public Map<String,Object> download(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        String filename = "2016-09-22-120538_819x489_scrot.png";
        response.setContentType("image/png;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String scpath = "/data/guanqian-8080/"+"filemanager";
        File file = new File(scpath, new String(filename.getBytes("utf-8"), "utf-8"));
        FileInputStream fis = new FileInputStream(file);
        System.out.println(filename);
        try {
            long fileLength = file.length();
            response.setContentType("image/png");
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bos.flush();
            jsonMap.put("code",200);
            jsonMap.put("msg","成功上传");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return jsonMap;
    }

    public static void main(String[] args) {
        String uploadPath=BatchFileUploadController.class.getResource("/").getAuthority().toString()+"filemanager";
        System.out.println(uploadPath);
        String uploadPath2=BatchFileUploadController.class.getResource("/").getPath().toString()+"filemanager";
        System.out.println(uploadPath2);
        String uploadPath3=BatchFileUploadController.class.getResource("/").getAuthority().toString();
        System.out.println(uploadPath3);
    }
}