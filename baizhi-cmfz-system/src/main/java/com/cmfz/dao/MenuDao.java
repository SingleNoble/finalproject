package com.cmfz.dao;

import com.cmfz.entity.Menu;

import java.util.List;

/**
 *
 */
public interface MenuDao extends BaseDao<Menu> {

    /**
     * 根据父级目录id查询
     * @param pid
     * @return
     */
    List<Menu> selectByParentId(String pid);

}
