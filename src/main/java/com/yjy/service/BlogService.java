package com.yjy.service;

import com.yjy.dto.CommonDto;
import com.yjy.pojo.Blog;

import java.util.List;

public interface BlogService {
    CommonDto addBlog(Blog blog);

    CommonDto updateBlog(Blog blog);

    CommonDto deleteBlog(Blog blog);

    CommonDto<Blog> getById(Integer id);

    CommonDto queryAll();

    CommonDto<List<Blog>> getAllTitleWithAuthor();
}
