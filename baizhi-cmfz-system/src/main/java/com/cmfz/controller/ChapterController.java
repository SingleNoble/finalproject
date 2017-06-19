package com.cmfz.controller;

import com.cmfz.Service.ChapterService;
import com.cmfz.entity.Album;
import com.cmfz.entity.Chapter;
import com.github.pagehelper.Page;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    //分页查询
    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String ,Object> queryByPage(Integer page, Integer rows,String albumId){
        Page<Chapter> albums = chapterService.queryByAlbum(page, rows,albumId);
        List<Chapter> result = albums.getResult();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",albums.getTotal());
        map.put("rows",result);
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void upload(HttpSession session, MultipartFile voice,Chapter chapter) {

        String realPath = session.getServletContext().getRealPath("/");
        realPath += "cmfz\\voice\\";

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }

        //获取文件后缀名
        String extension = FilenameUtils.getExtension(voice.getOriginalFilename());

        //重命名文件 新文件名为 系统当前时间戳 + 文件后缀名
        String newName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date())+"."+extension;

        String path = realPath + newName;

        chapter.setFilepath(path);
        chapter.setOldname(voice.getOriginalFilename());
        chapter.setNewname(newName);
        chapter.setFilesize(String.valueOf(voice.getSize()));
        chapter.setContenttype(voice.getContentType());

        System.out.println(chapter);

        try {
            voice.transferTo(new File(realPath+newName));
            chapterService.add(chapter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,String> delete(String id){
        Map<String,String> map=new HashMap<String,String>();
        try {
            chapterService.delete(id);
            map.put("message","删除成功!!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","删除失败！！！"+e.getMessage());
        }
        return map;
    }

}
