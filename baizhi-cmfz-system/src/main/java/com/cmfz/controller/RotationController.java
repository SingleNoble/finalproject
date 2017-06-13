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

    @RequestMapping
    public void uploadImg(MultipartFile multipartFile, HttpSession session,String description){
        String realPath = session.getServletContext().getRealPath("/");
        realPath += "/cmfz/image";

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取文件后缀名
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

        //重命名文件 新文件名为 系统当前时间戳 + 文件后缀名
        String newName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date())+"."+extension;

        Rotation rotation = new Rotation();
        rotation.setDescription(description);
        rotation.setFilepath(realPath+newName);

        try {
            rotationService.add(rotation);
            multipartFile.transferTo(new File(realPath+newName));
        }catch (Exception e){
            throw new RuntimeException("文件上传失败！！");
        }
    }

    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String,Object> queryByPage(Integer pageNum, Integer pageSize){
        pageNum = (pageNum == null || pageNum == 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize == 0) ? 2 : pageSize;
        Page<Rotation> page = rotationService.queryByPage(pageNum, pageSize);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",page.getTotal());
        map.put("rows",page.getResult());
        return map;
    }

}
