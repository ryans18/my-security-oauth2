package com.ryans.handler;

import cn.hutool.extra.servlet.ServletUtil;
import com.ryans.util.ServletUtils;
import com.ryans.util.result.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author：Ryans
 * Date：Created in 2023/10/4 23:06
 * Introduction：访问一个需要认证的URL资源，但是此时自己尚未认证(登录)的情况下，返回 401 错误码，从而使前端重定向到登录页
 */
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.debug("[commence][访问URL({}) 时， 没有登录]", request.getRequestURI());
        // 返回401
        Result<Object> result = Result.fail(HttpStatus.UNAUTHORIZED.value(),"账户未登录" );
        ServletUtils.writeJSON(response, result);
    }
}