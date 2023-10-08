package com.ryans.util;

import cn.hutool.extra.servlet.JakartaServletUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;


/**
 * Author：Ryans
 * Date：Created in 2023/10/4 22:55
 * Introduction：
 */
public class ServletUtils {

    // 必须使用APPLICATION_JSON_UTF8_VALUE
    // APPLICATION_JSON_UTF8_VALUE 被弃用 替换为APPLICATION_JSON_VALUE 新版会自动解析，不需要额外指定UTF-8字符集
    public static void writeJSON(HttpServletResponse response, Object object) {
        String content = JSONUtil.toJsonStr(object);
        JakartaServletUtil.write(response, content, MediaType.APPLICATION_JSON_UTF8_VALUE);
    }
}