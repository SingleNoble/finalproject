package com.cmfz.Service.impl;

import com.cmfz.Service.AlbumService;
import com.cmfz.dao.AlbumDao;
import com.cmfz.entity.Album;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 *
 */
@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Album> queryByPage(Integer pageNum, Integer pageSize) {
        Page<Album> page = PageHelper.startPage(pageNum, pageSize);
        albumDao.selectAll();
        return page;
    }

    @Transactional
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setCreatedate(new Date());
        albumDao.insert(album);
    }

    @Transactional
    public void delete(String id) {
        albumDao.delete(id);
    }

}
