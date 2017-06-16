package com.cmfz.controller;

import com.cmfz.Service.UserService;
import com.cmfz.entity.User;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String,Object> queryByPage(Integer page, Integer rows){
        Page<User> users = userService.queryByPage(page, rows);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("rows",users.getResult());
        map.put("total",users.getTotal());
        return map;
    }

}
