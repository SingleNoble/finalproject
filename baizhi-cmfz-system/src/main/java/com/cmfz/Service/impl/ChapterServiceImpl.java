package com.cmfz.Service.impl;

import com.cmfz.Service.ChapterService;
import com.cmfz.dao.ChapterDao;
import com.cmfz.entity.Chapter;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 *
 */
@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Chapter> queryByAlbum(Integer pageNum, Integer pageSize,String albumId) {
        Page<Chapter> page = PageHelper.startPage(pageNum, pageSize);
        chapterDao.selectByAlbum(albumId);
        return page;
    }

    @Transactional
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
    }

    @Transactional
    public void delete(String id) {
        chapterDao.delete(id);
    }
}
