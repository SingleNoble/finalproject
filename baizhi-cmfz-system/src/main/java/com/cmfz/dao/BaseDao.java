package com.cmfz.dao;

import java.util.List;

/**
 * 通用DAO层接口
 */
public interface BaseDao<T> {

    /**
     * 增
     * @param type
     */
    void insert(T type);

    /**
     * 删
     * @param id
     */
    void delete(String id);

    /**
     * 改
     * @param type
     */
    void update(T type);

    /**
     * 根据id查一个
     * @param id
     * @return
     */
    T selectById(String id);

    /**
     * 查所有
     * @return
     */
    List<T> selectAll();

}
