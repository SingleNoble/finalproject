package com.cmfz.Service;

import com.cmfz.entity.Rotation;
import com.github.pagehelper.Page;

import java.util.List;

/**
 *
 */
public interface RotationService {

    /**
     * 添加图片信息
     * @param rotation
     */
    void add(Rotation rotation);

    /**
     * 分页查询所有图片
     * @return
     */
    Page<Rotation> queryByPage(Integer pageNum,Integer pageSize);

}
