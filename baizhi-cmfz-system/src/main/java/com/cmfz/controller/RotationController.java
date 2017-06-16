package com.cmfz.controller;

import com.cmfz.Service.RotationService;
import com.cmfz.entity.Rotation;
import com.github.pagehelper.Page;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/rotation")
public class RotationController {
    @Resource
    private RotationService rotationService;

    @RequestMapping("/add")
    public String uploadImg(MultipartFile multipartFile, HttpSession session,String description){
        String realPath = session.getServletContext().getRealPath("/");
        realPath += "cmfz\\image\\";

        System.out.println(realPath);

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取文件后缀名
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

        //重命名文件 新文件名为 系统当前时间戳 + 文件后缀名
        String newName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date())+"."+extension;

        System.out.println(newName);

        Rotation rotation = new Rotation();
        rotation.setDescription(description);
        rotation.setFilepath(realPath+newName);

        try {
            rotationService.add(rotation);
            multipartFile.transferTo(new File(realPath+newName));
        }catch (Exception e){
            throw new RuntimeException("文件上传失败！！");
        }
        return "";
    }

    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String,Object> queryByPage(Integer page, Integer rows){
        Page<Rotation> pages = rotationService.queryByPage(page, rows);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",pages.getTotal());
        map.put("rows",pages.getResult());
        return map;
    }

    @RequestMapping("drop")
    public String drop(String id){
        rotationService.drop(id);
        return "success";
    }

}
