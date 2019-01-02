package com.yjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @GetMapping("/{page}")
    public String getPage(@PathVariable String page,String redirect, HttpServletRequest request) {
        if (!StringUtils.isEmpty(redirect)){
            request.setAttribute("redirect",redirect);
        }
        return page;
    }
}
