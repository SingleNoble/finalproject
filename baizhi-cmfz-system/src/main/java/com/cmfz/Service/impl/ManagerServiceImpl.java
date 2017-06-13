package com.cmfz.Service.impl;

import com.cmfz.Service.ManagerService;
import com.cmfz.dao.ManagerDao;
import com.cmfz.entity.Manager;
import com.cmfz.util.MD5Util;
import com.cmfz.util.SaltUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 *
 */
@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Transactional
    public void add(Manager manager) {
        manager.setId(UUID.randomUUID().toString());
        String salt = SaltUtil.getSalt(4);
        manager.setSalt(salt);
        manager.setPassword(MD5Util.getMd5Code(manager.getPassword()+salt));
        managerDao.insert(manager);
    }
    @Transactional
    public void drop(String id) {

    }
    @Transactional
    public void change(Manager manager) {

    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Manager queryById(String id) {
        return null;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Manager> queryByPage(Integer pageNum,Integer pageSize) {
        Page<Manager> page = PageHelper.startPage(pageNum, pageSize);
        managerDao.selectAll();
        return page;
    }
    @Transactional
    public Manager login(Manager manager) {

        Manager managerDB = managerDao.selectByName(manager.getName());
        if (managerDB!=null){
            String password = MD5Util.getMd5Code(manager.getPassword() + managerDB.getSalt());
            if (password.equals(managerDB.getPassword())){
                return managerDB;
            }else {
                throw new RuntimeException("密码错误！！");
            }
        } else {
            throw new RuntimeException("用户不存在！！");
        }
    }
}
