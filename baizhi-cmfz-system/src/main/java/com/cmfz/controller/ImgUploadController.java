package com.cmfz.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Controller
@RequestMapping("/imgUpload")
public class ImgUploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpSession session, MultipartFile multipartFile) {
        String realPath = session.getServletContext().getRealPath("/");
        realPath += "cmfz\\image\\";

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取文件后缀名
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

        //重命名文件 新文件名为 系统当前时间戳 + 文件后缀名
        String newName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date())+"."+extension;


        String path=null;
        try {
            multipartFile.transferTo(new File(realPath+newName));
            path = realPath + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(path);
        return path;
    }
}

