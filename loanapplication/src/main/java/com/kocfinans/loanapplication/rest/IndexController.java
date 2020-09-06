package com.kocfinans.loanapplication.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index () {
        return "index.html";
    }


    @RequestMapping("/swagger")
    public String swagger () {
        return "swagger.html";
    }

}
