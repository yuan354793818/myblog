package com.yjy.service.impl;

import com.yjy.dao.BlogDAO;
import com.yjy.dto.CommonDto;
import com.yjy.enums.CommonState;
import com.yjy.pojo.Blog;
import com.yjy.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlogDAO blogDAO;

    public CommonDto addBlog(Blog blog) {
        if (blog == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        blog.setCreateTime(new Date());
        blog.setUpdateTime(blog.getCreateTime());
        try {
            blogDAO.insert(blog);
        } catch (Exception e) {
           logger.error(e.getMessage(),e);
            return new CommonDto(false, CommonState.INNER_ERROR);
        }
        return new CommonDto(true);
    }

    public CommonDto updateBlog(Blog blog) {
        if (blog == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        blog.setUpdateTime(new Date());
        try {
            blogDAO.updateByPrimaryKeySelective(blog);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new CommonDto(false, CommonState.INNER_ERROR);
        }
        return new CommonDto(true);
    }

    public CommonDto deleteBlog(Blog blog) {
        if (blog == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        try {
            blogDAO.deleteByPrimaryKey(blog.getBlogId());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new CommonDto(false, CommonState.INNER_ERROR);
        }
        return new CommonDto(true);
    }

    public CommonDto<Blog> getById(Integer id) {
        if (id == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        Blog blog = blogDAO.selectByPrimaryKey(id);
        return new CommonDto<Blog>(blog,true);
    }

    public CommonDto queryAll() {
        return null;
    }


    public CommonDto<List<Blog>> getAllTitleWithAuthor() {
        List<Blog> list = blogDAO.getAllTitleWithAuthor();
        return new CommonDto<List<Blog>>(list,true);
    }
}
