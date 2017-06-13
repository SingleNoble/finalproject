package com.cmfz.controller;

import com.cmfz.Service.MenuService;
import com.cmfz.entity.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Menu> queryAll(){
        List<Menu> menus = menuService.queryAll();
        return menus;
    }

}
