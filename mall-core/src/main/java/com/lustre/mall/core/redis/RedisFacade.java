package com.lustre.mall.core.redis;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisFacade implements BloomFilter,RedisOperation{

    private RedisTemplate<String,String> redisTemplate;

    private BloomFilter bloomFilter;

    private RedisOperation redisOperation;

    public RedisFacade(RedisTemplate<String, String> redisTemplate) {
        this(redisTemplate,0.1,10000);
    }

    public RedisFacade(RedisTemplate<String, String> redisTemplate,double odds, long numInsert) {
        this.redisTemplate = redisTemplate;
        this.redisOperation = new RedisOperationImpl(redisTemplate);
        this.bloomFilter = new BloomFilterImpl(odds,numInsert,this.redisOperation);
    }


    @Override
    public void put(String bloom, String value) {
        this.bloomFilter.put(bloom,value);
    }

    @Override
    public Boolean contains(String bloom, String value) {
        return bloomFilter.contains(bloom,value);
    }

    @Override
    public void set(String key, String value) {
        redisOperation.set(key,value);
    }

    @Override
    public String get(String key) {
        return redisOperation.get(key);
    }

    @Override
    public String getSet(String key, String value) {
        return redisOperation.getSet(key,value);
    }

    @Override
    public Boolean getBit(String key, Long offset) {
        return redisOperation.getBit(key,offset);
    }

    @Override
    public Boolean setBit(String key, Long offset, Boolean value) {
        return redisOperation.setBit(key,offset,value);
    }

    @Override
    public Boolean delete(String key) {
        return redisOperation.delete(key);
    }

    @Override
    public Boolean expire(String key, Long seconds) {
        return redisOperation.expire(key,seconds);
    }

    @Override
    public Boolean setNX(String key, String value) {
        return redisOperation.setNX(key,value);
    }

    @Override
    public Boolean lock(String lock) {
        return redisOperation.lock(lock);
    }

    @Override
    public Boolean unlock(String lock) {
        return redisOperation.unlock(lock);
    }
}
