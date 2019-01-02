package com.yjy.service.impl;

import com.yjy.dao.CommentDAO;
import com.yjy.dto.CommonDto;
import com.yjy.enums.CommonState;
import com.yjy.pojo.Comment;
import com.yjy.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentDAO commentDAO;


    public CommonDto addComment(Comment comment) {
        if (comment == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        comment.setCreateTime(new Date());
        try {
            commentDAO.insert(comment);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new CommonDto(false, CommonState.INNER_ERROR);
        }
        return new CommonDto(true);
    }

    public CommonDto deleteComment(Comment comment) {
        if (comment == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        try {
            commentDAO.deleteByPrimaryKey(comment.getCommentId());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new CommonDto(false, CommonState.INNER_ERROR);
        }
        return  new CommonDto(true);
    }

    public CommonDto<Comment> getById(Integer id) {
        if (id == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        Comment comment = commentDAO.selectByPrimaryKey(id);
        return new CommonDto<Comment>(comment,true);
    }

    public CommonDto<List<Comment>> queryAll() {
        List<Comment> comments = commentDAO.selectByExample(null);
        return new CommonDto<List<Comment>>(comments,true);
    }

    public CommonDto<List<Comment>> getAllCommentByBlogIdWithUser(Integer blogId) {
        if (blogId == null) {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
        List<Comment> comments = commentDAO.getAllCommentByBlogIdWithUser(blogId);
        return new CommonDto<List<Comment>>(comments,true);
    }
}
