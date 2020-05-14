package com.lustre.mall.core.config;

import com.lustre.mall.core.redis.LockTemplate;
import com.lustre.mall.core.redis.RedisFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisConfig {

    @Bean
    public RedisFacade redisFacade(StringRedisTemplate stringRedisTemplate){
        return new RedisFacade(stringRedisTemplate);
    }

    @Bean
    public LockTemplate lockTemplate(RedisFacade redisFacade){
        return new LockTemplate(redisFacade);
    }

}
