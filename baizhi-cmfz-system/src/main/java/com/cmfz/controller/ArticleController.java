package com.cmfz.controller;

import com.cmfz.entity.Article;
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
@Controller
@RequestMapping("/article")
public class ArticleController {


   /* @RequestMapping("/queryAllByPage")
    @ResponseBody
    public Map<String ,Object> queryAllByPage(Integer page, Integer rows){
        //Page<Article> articles = articleService.queryAllByPage(page, rows);
        List<Article> result = articles.getResult();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",articles.getTotal());
        map.put("rows",result);
        return map;
    }*/

}
