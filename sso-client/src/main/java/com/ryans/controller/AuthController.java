package com.ryans.controller;

import com.ryans.dto.Oauth2AccessTokenDto;
import com.ryans.util.result.Result;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author：Ryans
 * Date：Created in 2023/10/6 23:03
 * Introduction：
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login-by-code")
    public Result<Oauth2AccessTokenDto> loginByCode(@RequestParam("code")String code, @RequestParam("redirectUri") String redirectUri) {
        try {
            String url = "http://127.0.0.1:9000/oauth2/token";
            HttpHeaders httpHeaders = getHttpHeaders();
            MultiValueMap<String, Object> body = getBody(code, redirectUri);
            ResponseEntity<Oauth2AccessTokenDto> exchange = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body,httpHeaders), Oauth2AccessTokenDto.class);
            return Result.data(exchange.getBody());
        } catch (Exception e) {
            return Result.fail("获取失败");
        }
    }

    private MultiValueMap<String, Object> getBody(String code, String redirectUri) {
        MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();
        body.add("code", code);
        body.add("grant_type", "authorization_code");
        body.add("redirect_uri", redirectUri);
        return body;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String clientId = "sso_client";
        String secret = "123456";
        String client = clientId + ":" + secret;
        String encodeClient = Base64Util.encode(client);
        httpHeaders.set("Authorization", "Basic " + encodeClient);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return httpHeaders;
    }
}