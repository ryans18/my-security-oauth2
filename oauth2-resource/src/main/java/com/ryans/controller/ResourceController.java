package com.ryans.controller;

import com.alibaba.fastjson2.JSON;
import com.ryans.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：Ryans
 * Date：Created in 2023/9/27 22:24
 * Introduction：
 */
@RestController
public class ResourceController {
    @GetMapping("/res1")
    public String getRes1(){
        return JSON.toJSONString(new Result(200, "服务A -> 资源1"));
    }

    @GetMapping("/res2")
    public String getRes2(){
        return JSON.toJSONString(new Result(200, "服务A -> 资源2"));
    }
}