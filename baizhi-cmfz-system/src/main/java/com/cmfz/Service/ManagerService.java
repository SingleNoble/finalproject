package com.cmfz.Service;

import com.cmfz.entity.Manager;

import java.util.List;

/**
 *
 */
public interface ManagerService {

    /**
     * 注册管理员
     * @param manager
     */
    void add(Manager manager);

    /**
     * 删除管理员
     * @param id
     */
    void drop(String id);

    /**
     * 修改管理员信息
     * @param manager
     */
    void change(Manager manager);

    /**
     * 根据id查询管理员信息
     * @param id
     * @return
     */
    Manager queryById(String id);

    /**
     * 查询所有管理员信息
     * @return
     */
    List<Manager> queryAll();

    /**
     * 登录验证
     * @param manager
     * @return
     */
    Manager login(Manager manager);

}
