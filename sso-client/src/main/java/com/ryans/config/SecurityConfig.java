package com.ryans.config;

import com.ryans.handler.AccessDeniedHandlerImpl;
import com.ryans.handler.AuthenticationEntryPointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Author：Ryans
 * Date：Created in 2023/10/4 23:24
 * Introduction：
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                // 1. 静态资源, 可匿名访问
                .requestMatchers("/*.html", "/**.html","/**.css","/**.js").permitAll()
                // 2. 登录相关接口，可匿名访问
                .requestMatchers("/auth/login-by-code", "/auth/refresh-token", "/auth/logout").permitAll()
                // 3. 其它请求，必须认证
                .anyRequest().authenticated()
        );
//        http.formLogin(formLogin -> formLogin.disable());
        // error处理器
        http.exceptionHandling(except -> except
                .authenticationEntryPoint(new AuthenticationEntryPointImpl())
                .accessDeniedHandler(new AccessDeniedHandlerImpl())
        );
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}