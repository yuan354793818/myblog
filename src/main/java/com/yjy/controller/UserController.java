package com.yjy.controller;

import com.yjy.dto.CommonDto;
import com.yjy.pojo.User;
import com.yjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(User user,String redirect, HttpServletRequest request) {
        System.out.println(user);
        System.out.println("redirect is : "+redirect);
        CommonDto<User> result = userService.login(user);

        if (!result.isSuccess()) {
            return "login";
        }
        request.getSession().setAttribute("loginUser",user);

       if (!StringUtils.isEmpty(redirect)){
           return "redirect:" + redirect;
       }

        return "redirect:/blog/homepage";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,String redirect) {

        request.getSession().setAttribute("loginUser",null);

        if (!StringUtils.isEmpty(redirect)){
            return "redirect:"+redirect;
        }

        return "redirect:/blog/homepage";
    }

    public static void main(String[] args) {
        String s = DigestUtils.md5DigestAsHex("111111".getBytes());
        System.out.println(s);
    }
}
