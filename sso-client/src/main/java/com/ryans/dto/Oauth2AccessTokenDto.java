package com.ryans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author：Ryans
 * Date：Created in 2023/10/6 23:23
 * Introduction：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oauth2AccessTokenDto {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    // 令牌类型
    @JsonProperty("token_type")
    private String tokenType;
    // 过期时间，单位s
    @JsonProperty("expires_in")
    private long expiresIn;
    // 授权范围，如果有多个授权范围，用空格隔开
    private String scope;
}