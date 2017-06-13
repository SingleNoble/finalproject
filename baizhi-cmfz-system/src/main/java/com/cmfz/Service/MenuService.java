package com.cmfz.Service;

import com.cmfz.entity.Menu;

import java.util.List;

/**
 *
 */
public interface MenuService {

    /**
     * 查询所有目录
     * @return
     */
    List<Menu> queryAll();

}
