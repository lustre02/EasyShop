package com.lustre.mall.core.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableOAuth2Client
public class OAuthClientConfig {
    @Bean
    public RequestInterceptor requestInterceptor(@Qualifier("oauth2ClientContext") OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails) {
        return new OAuth2FeignRequestInterceptor(oAuth2ClientContext, oAuth2ProtectedResourceDetails);
    }

    @Bean
    @LoadBalanced
    public OAuth2RestTemplate oAuth2RestTemplate(@Qualifier("oauth2ClientContext") OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails) {
        return new OAuth2RestTemplate(oAuth2ProtectedResourceDetails, oAuth2ClientContext);
    }
}
