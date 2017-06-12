package com.cmfz.dao;

import com.cmfz.entity.Manager;

public interface ManagerDao extends BaseDao<Manager> {

    /**
     * 通过名字查询manager
     * @param name
     * @return
     */
    Manager selectByName(String name);

}
