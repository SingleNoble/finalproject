package com.cmfz.Service;

import com.cmfz.entity.User;
import com.github.pagehelper.Page;

/**
 *
 */
public interface UserService {

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<User> queryByPage(Integer pageNum,Integer pageSize);

}
