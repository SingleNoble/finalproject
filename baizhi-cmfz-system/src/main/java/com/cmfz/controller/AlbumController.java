package com.cmfz.controller;

import com.cmfz.Service.AlbumService;
import com.cmfz.entity.Album;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RequestMapping("/album")
@Controller
public class AlbumController {
    @Resource
    private AlbumService albumService;

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public Map<String,String> add(Album album){
        Map<String,String> map=new HashMap<String, String>();
        try {
            albumService.add(album);
            map.put("message","创建成功!!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","创建失败!!!!"+e.getMessage());
        }
        return map;
    }
    //分页查询
    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String ,Object> queryByPage(Integer page,Integer rows){
        Page<Album> albums = albumService.queryByPage(page, rows);
        List<Album> result = albums.getResult();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",albums.getTotal());
        map.put("rows",result);
        return map;
    }
    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,String> drop(String id){
        Map<String,String> map=new HashMap<String,String>();
        try {
            albumService.delete(id);
            map.put("message","删除成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","删除失败！！"+e.getMessage());
        }
        return map;
    }

}
