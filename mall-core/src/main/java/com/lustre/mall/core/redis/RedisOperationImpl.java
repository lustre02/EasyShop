package com.lustre.mall.core.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisOperationImpl implements RedisOperation {

    private RedisTemplate<String, String> redisTemplate;


    public RedisOperationImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public String getSet(String key, String value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    @Override
    public Boolean getBit(String key, Long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    @Override
    public Boolean setBit(String key, Long offset, Boolean value) {
        return redisTemplate.opsForValue().setBit(key, offset, value);
    }

    @Override
    public Boolean expire(String key, Long milliSeconds) {
        return redisTemplate.expire(key, milliSeconds, TimeUnit.MILLISECONDS);
    }

    @Override
    public Boolean setNX(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Boolean lock(String lock) {

        if (this.setNX(lock, String.valueOf(System.currentTimeMillis() + 5000))) {
            return true;
        } else {
            String value = this.get(lock);

            if (value == null) {
                return this.setNX(lock, String.valueOf(System.currentTimeMillis() + 5000));
            } else {
                Long time = Long.valueOf(value);

                if (time < System.currentTimeMillis()) {
                    String oldValue = this.getSet(lock, String.valueOf(System.currentTimeMillis() + 5000 + 1));
                    return oldValue == null ? null : Long.valueOf(oldValue) < System.currentTimeMillis();
                }
            }

        }
        return false;
    }

    @Override
    public Boolean unlock(String lock) {
        return this.delete(lock);
    }
}
