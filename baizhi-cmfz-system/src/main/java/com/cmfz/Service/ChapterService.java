package com.cmfz.Service;

import com.cmfz.entity.Chapter;
import com.github.pagehelper.Page;

/**
 *
 */
public interface ChapterService {

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Chapter> queryByAlbum(Integer pageNum, Integer pageSize,String albumId);

    /**
     * 添加
     * @param chapter
     */
    void add(Chapter chapter);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

}
