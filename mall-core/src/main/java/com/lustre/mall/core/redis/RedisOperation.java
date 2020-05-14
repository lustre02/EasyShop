package com.lustre.mall.core.redis;

public interface RedisOperation {
    void set(String key, String value);

    String get(String key);

    String getSet(String key, String value);

    Boolean getBit(String key, Long offset);

    Boolean setBit(String key, Long offset, Boolean value);

    Boolean delete(String key);

    Boolean expire(String key, Long seconds);

    Boolean setNX(String key, String value);

    Boolean lock(String lock);

    Boolean unlock(String lock);
}
