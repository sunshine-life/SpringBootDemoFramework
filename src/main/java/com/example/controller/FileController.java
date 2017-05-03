package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by life on 2015/12/30.
 */
@RestController
@RequestMapping("/file")
public class FileController {
    private  String page_list = "index";

    /**
     * 文件的上传
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadfile")
    @ResponseBody
    public Map<String,Object> save(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        System.out.println("进入上传文件的方法");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ////创建一个通用的多部分解析器.
        MultipartResolver multipartResolver =
                new CommonsMultipartResolver(request.getSession().getServletContext());
        //转换成多部分request
        MultipartHttpServletRequest multipartRequest =
                multipartResolver.resolveMultipart(request);
        // uploadFile 是指文件上传标签的 name=值
        // 根据 name 获取上传的文件...
        MultipartFile file = multipartRequest.getFile("uploadFile");
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if(file.isEmpty()){
            jsonMap.put("status", -1);
            jsonMap.put("result", "【文件为空！】");
            System.out.println("【文件为空！】");
            return jsonMap;
        }
        String fileName=file.getOriginalFilename();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        //String uploadPath=request.getSession().getServletContext().getRealPath(Constants.UPLOAD_FILE_DIR+sdf.format(new Date()));
        String uploadPath=request.getSession().getServletContext().getRealPath("/filemanager");
        System.out.println(uploadPath);
        File uploadDir=new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        File uploadFile=new File(uploadPath+"/"+fileName);
        file.transferTo(uploadFile);//上传
        System.out.println("上传成功！");
        jsonMap.put("status", 1);
        jsonMap.put("result", "【上传成功！】");
        return jsonMap;
    }

    /**
     * 文件下载（注：ajax不能异步请求文件下载！！！！！）
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/downloadfile")
    public Map<String,Object> download(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        String filename = request.getParameter("filename");
        System.out.println("进入下载文件的方法");
        //response.setContentType("application/x-msdownload;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        //String scpath = "/data/guanqian-8080/"+"filemanager";

        String scpath2 = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(scpath2.toString());
        String scpath = request.getSession().getServletContext().getRealPath("/filemanager");
        File file = new File(scpath, new String(filename.getBytes("utf-8"), "utf-8"));
        FileInputStream fis = new FileInputStream(file);
        System.out.println(filename);
        try {
            long fileLength = file.length();
            response.setContentType("application/x-msdownload;charset=utf-8");
            response.setHeader("Content-disposition", "attachment; filename=" + "testdownload.text");
            response.setHeader("Content-Length", String.valueOf(fileLength));

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
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
}