package com.lustre.mall.core.dto;

import lombok.Data;

@Data
public class OAuthTokenDTO {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
}
