package com.ryans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author : Ryans
 * Date : 2023/9/28
 * Introduction :
 */
@Controller
public class IndexController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
