package com.cmfz.Service;

import com.cmfz.entity.Feedback;
import com.github.pagehelper.Page;

/**
 *
 */
public interface FeedbackService {

    /**
     * 查询所有
     * @return
     */
    Page<Feedback> queryByPage(Integer pageNum,Integer pageSize);

}
