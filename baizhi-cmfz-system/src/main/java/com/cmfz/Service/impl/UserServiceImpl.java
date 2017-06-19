package com.cmfz.Service.impl;

import com.cmfz.Service.UserService;
import com.cmfz.dao.UserDao;
import com.cmfz.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<User> queryByPage(Integer pageNum, Integer pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        userDao.selectAll();
        return page;
    }

    @Transactional
    public void delete(String id) {
        userDao.delete(id);
    }
}
