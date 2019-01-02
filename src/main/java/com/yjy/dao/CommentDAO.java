package com.yjy.dao;

import com.yjy.pojo.Comment;
import com.yjy.pojo.CommentExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CommentDAO继承基类
 */
@Repository
public interface CommentDAO extends MyBatisBaseDao<Comment, Integer, CommentExample> {
    List<Comment> getAllCommentByBlogIdWithUser(Integer blogId);
}