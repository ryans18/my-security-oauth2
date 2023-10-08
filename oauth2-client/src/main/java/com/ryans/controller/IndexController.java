package com.ryans.controller;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author：Ryans
 * Date：Created in 2023/9/28 21:44
 * Introduction：
 */
@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        // 从Security上下文获取用户信息并返回给前台
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> map = new HashMap<>(2);
        map.put("username", authentication.getName());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> authList = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        map.put("authorities", authList);
        model.addAttribute("user", JSON.toJSONString(map));
        return "index";
    }

    // 自定义登出，解决登出后认证服务器的授权信息没有清除
    @GetMapping("/out")
    public void out(HttpServletRequest request, HttpServletResponse response) {
        // ========== 清理客户端 ===========
        // 清理客户端session
        request.getSession().invalidate();
        // 清理客户端安全上下文
        SecurityContextHolder.clearContext();

        // ========== 清理认证中心 ===========
        // 跳转至认证中心退出页面
        try {
            response.sendRedirect("http://os.com:9000/logout");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}