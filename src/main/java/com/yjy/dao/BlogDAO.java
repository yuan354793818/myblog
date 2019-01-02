package com.yjy.dao;

import com.yjy.pojo.Blog;
import com.yjy.pojo.BlogExample;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * BlogDAO继承基类
 */
@Repository
public interface BlogDAO extends MyBatisBaseDao<Blog, Integer, BlogExample> {
    List<Blog> getAllTitleWithAuthor();
}