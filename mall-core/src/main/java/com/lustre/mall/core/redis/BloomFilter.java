package com.lustre.mall.core.redis;

public interface BloomFilter {

    void put(String bloom, String value);

    Boolean contains(String bloom, String value);

}
