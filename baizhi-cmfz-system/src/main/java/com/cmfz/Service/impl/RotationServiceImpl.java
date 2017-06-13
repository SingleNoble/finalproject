package com.cmfz.Service.impl;

import com.cmfz.Service.RotationService;
import com.cmfz.dao.RotationDao;
import com.cmfz.entity.Rotation;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service("rotationService")
@Transactional
public class RotationServiceImpl implements RotationService {
    @Autowired
    private RotationDao rotationDao;
    @Transactional
    public void add(Rotation rotation) {
        rotation.setId(UUID.randomUUID().toString());
        rotationDao.insert(rotation);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Rotation> queryByPage(Integer pageNum,Integer PageSize) {
        Page<Rotation> page = PageHelper.startPage(pageNum, PageSize);
        rotationDao.selectAll();
        return page;
    }

}
