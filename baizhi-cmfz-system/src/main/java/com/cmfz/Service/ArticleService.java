package com.cmfz.Service;

import com.cmfz.entity.Article;

/**
 *
 */
public interface ArticleService {

    /**
     * 添加
     * @param article
     */
    void add(Article article);

    /**
     * 删除
     * @param id
     */
    void delete(String id);



}
