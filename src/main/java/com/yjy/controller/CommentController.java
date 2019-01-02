package com.yjy.controller;

import com.yjy.dto.CommonDto;
import com.yjy.pojo.Blog;
import com.yjy.pojo.Comment;
import com.yjy.service.BlogService;
import com.yjy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @PostMapping("/{blogId}/spoken")
    @ResponseBody
    public CommonDto doReview(@PathVariable Integer blogId, String speech) {

        //判断是否有输入
        if (speech!=null&&!speech.trim().equals("")&&blogId!=null){

            Blog blog = blogService.getById(blogId).getData();
            //判断博客是否存在
            if (blog != null) {
                Comment comment=new Comment();
                comment.setBlogId(blogId);
                comment.setcContent(speech);
                return commentService.addComment(comment);
            }
        }

        return new CommonDto(false);
    }

    @GetMapping("/{commentId}/delete")
    @ResponseBody
    public CommonDto deleteComment(@PathVariable Integer commentId) {

        Comment comment=new Comment();
        comment.setCommentId(commentId);

        return commentService.deleteComment(comment);
    }
}
