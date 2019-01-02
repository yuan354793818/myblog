package com.yjy.controller;

import com.yjy.dto.CommonDto;
import com.yjy.pojo.Blog;
import com.yjy.pojo.Comment;
import com.yjy.pojo.User;
import com.yjy.service.BlogService;
import com.yjy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    /**
     * 在每一个handler中加入loginUser 如果session中有
     * @return
     */
    @ModelAttribute("loginUser")
    public User putLoginUser(HttpServletRequest request) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return loginUser;
        }
        return null;
    }

    /**
     * 在每一个handler中加入prePageUri已备一些需要在另一个页面操作后返回，如主页->编辑某个->提交后返回主页
     * @return
     */
    @ModelAttribute("prePageUri")
    public String putPrePageUri(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @GetMapping("/homepage")
    public String showHomePage(Model model, HttpServletRequest request) {

        CommonDto<List<Blog>> commonDto = blogService.getAllTitleWithAuthor();
        model.addAttribute("titlelist", commonDto.getData());

        return "home";
    }

    @GetMapping("/add")
    public String showAddPage() {
        return "add";
    }

    @GetMapping("/{blogId}/show")
    public String showBlog(@PathVariable("blogId") Integer blogId,Model model,HttpServletRequest request) {

        CommonDto<Blog> blogDto = blogService.getById(blogId);
        CommonDto<List<Comment>> commentDto = commentService.getAllCommentByBlogIdWithUser(blogId);

        model.addAttribute("blog", blogDto.getData());
        model.addAttribute("comment", commentDto.getData());

        //展示前后id
        List<Blog> blogList = blogService.getAllTitleWithAuthor().getData();

        if (blogList != null && blogList.size() != 0) {
            Blog buf=null;
            for (Blog blog : blogList) {
                if (blog.getBlogId().equals(blogId)) {
                    buf = blog;
                }
            }

            int i = blogList.indexOf(buf);

            if (i > 0) {
                model.addAttribute("preBlog", blogList.get(i - 1).getBlogId());
            }

            if (i < blogList.size()-1) {
                model.addAttribute("nextBlog", blogList.get(i + 1).getBlogId());
            }
        }

        return "show";
    }


    @GetMapping("/{blogId}/edition")
    public String showEdit(@PathVariable("blogId") Integer blogId,Model model) {

        CommonDto<Blog> blogDto = blogService.getById(blogId);

        model.addAttribute("blog", blogDto.getData());

        return "edit";
    }

    @PostMapping(value = "/submit/addtion",produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonDto addSubmit(Blog blog) {

        blogService.addBlog(blog);

        return new CommonDto(true);
    }

    @PostMapping(value = "/submit/update",produces = "application/json;charset=utf-8")
    @ResponseBody
    public CommonDto updateSubmit(Blog blog) {

        blogService.updateBlog(blog);

        return new CommonDto(true);
    }

}
