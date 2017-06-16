package com.cmfz.Service;

import com.cmfz.entity.Rotation;
import com.github.pagehelper.Page;

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

    /**
     * 删除
     * @param id
     */
    void drop(String id);

}
