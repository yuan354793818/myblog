package com.yjy.service;

import com.yjy.dto.CommonDto;
import com.yjy.pojo.Comment;

import java.util.List;

public interface CommentService {

    CommonDto addComment(Comment comment);

    CommonDto deleteComment(Comment comment);

    CommonDto<Comment> getById(Integer id);

    CommonDto<List<Comment>> queryAll();

    CommonDto<List<Comment>> getAllCommentByBlogIdWithUser(Integer blogId);
}
