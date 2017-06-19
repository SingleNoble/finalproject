package com.cmfz.Service;

import com.cmfz.entity.Album;
import com.github.pagehelper.Page;

/**
 *
 */
public interface AlbumService {

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Album> queryByPage(Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param album
     */
    void add(Album album);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

}
