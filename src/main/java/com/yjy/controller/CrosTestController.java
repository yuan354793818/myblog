package com.yjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cros")
public class CrosTestController {

    @CrossOrigin//(accept origin)
    @RequestMapping("/get")
    @ResponseBody
    public String getTest() {

        return "THIS HANDLER CAN VISIT BY CROS";
    }
}
