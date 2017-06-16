package com.cmfz.Service.impl;

import com.cmfz.Service.FeedbackService;
import com.cmfz.dao.FeedbackDao;
import com.cmfz.entity.Feedback;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service("FeedbackService")
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Feedback> queryByPage(Integer pageNum,Integer pageSize) {
        Page<Feedback> page = PageHelper.startPage(pageNum, pageSize);
        feedbackDao.selectAll();
        return page;
    }
}
