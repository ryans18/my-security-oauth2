package com.ryans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

/**
 * Author：Ryans
 * Date：Created in 2023/9/28 21:33
 * Introduction：
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                // 任何请求都需要认证
                .anyRequest().authenticated());
        // oauth2三方登录
        http.oauth2Login(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public RestTemplate oauth2ClientRestTemplate() {
        return new RestTemplate();
    }

}