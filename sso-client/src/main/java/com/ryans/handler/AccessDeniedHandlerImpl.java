package com.ryans.handler;

import com.ryans.util.ServletUtils;
import com.ryans.util.result.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author：Ryans
 * Date：Created in 2023/10/4 23:12
 * Introduction：访问一个需要认证的URL资源，已经认证(登录)但是没有权限的情况下，返回403 错误码
 */
@Slf4j
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        log.warn("访问URL{}时，用户({}) 权限不够", request.getRequestURI(), SecurityUtils.getLoginUserId());
        // 返回403
        Result<Object> result = Result.fail(HttpStatus.FORBIDDEN.value(),"没有权限操作" );
        ServletUtils.writeJSON(response, result);
    }
}