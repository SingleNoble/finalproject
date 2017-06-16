package com.cmfz.controller;

import com.cmfz.Service.FeedbackService;
import com.cmfz.entity.Feedback;
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
@RequestMapping("/feedback")
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String,Object> queryByPage(Integer page,Integer rows){
        Page<Feedback> feedbacks = feedbackService.queryByPage(page, rows);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("rows",feedbacks.getResult());
        map.put("total",feedbacks.getTotal());
        return map;
    }

}
