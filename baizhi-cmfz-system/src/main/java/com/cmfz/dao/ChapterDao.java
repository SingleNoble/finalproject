package com.cmfz.dao;

import com.cmfz.entity.Chapter;

import java.util.List;

/**
 *
 */
public interface ChapterDao extends BaseDao<Chapter> {

    /**
     * 根据专辑查询
     * @param albumId
     * @return
     */
    List<Chapter> selectByAlbum(String albumId);

}
