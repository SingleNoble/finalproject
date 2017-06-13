package com.cmfz.controller;

import com.cmfz.Service.ManagerService;
import com.cmfz.entity.Manager;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private ManagerService managerService;

    @RequestMapping("/login")
    public String login(Manager manager, HttpSession session){
        System.out.println(manager);
        Manager managerDB = null;
        try {
            managerDB = managerService.login(manager);
            session.setAttribute("manager",managerDB);
            return "redirect:/cmfz/main/main.jsp";
        }catch (Exception e){
            String message = e.getMessage();
            System.out.println(message);
        }
        return "redirect:/cmfz/user/login.jsp";
    }
    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String,Object> queryByPage(Integer pageNum, Integer pageSize){
        pageNum = (pageNum == null || pageNum == 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize == 0) ? 2 : pageSize;
        Page<Manager> page = managerService.queryByPage(pageNum, pageSize);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",page.getTotal());
        map.put("rows",page.getResult());
        return map;
    }

}
