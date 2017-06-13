package com.cmfz.controller;

import com.cmfz.Service.ManagerService;
import com.cmfz.entity.Manager;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public void queryByPage(Integer pageNum,Integer pageSize){
        Page<Manager> managers = managerService.queryByPage(pageNum, pageSize);
    }

}
