package com.cmfz.Service.impl;

import com.cmfz.Service.MenuService;
import com.cmfz.dao.MenuDao;
import com.cmfz.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAll() {
        List<Menu> menus = menuDao.selectAll();
        return menus;
    }
}
