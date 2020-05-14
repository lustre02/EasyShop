package com.lustre.mall.core.redis;

import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;

import java.nio.charset.Charset;

public class BloomFilterImpl implements BloomFilter {
    private int numHashFunctions;

    private int bitmapLength;

    private RedisOperation redisOperation;

    public BloomFilterImpl(double odds, long numInsert, RedisOperation redisOperation) {
        this.redisOperation = redisOperation;
        this.bitmapLength = (int) (-numInsert * Math.log(odds) / (Math.log(2) * Math.log(2)));
        this.numHashFunctions = Math.max(1, (int) Math.round((double) bitmapLength / numInsert * Math.log(2)));
    }

    private long[] getOffset(String value) {
        long[] indices = new long[numHashFunctions];

        byte[] bytes = Hashing.murmur3_128()
                .hashObject(value, Funnels.stringFunnel(Charset.forName("UTF-8")))
                .asBytes();

        long hash1 = Longs.fromBytes(
                bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]
        );
        long hash2 = Longs.fromBytes(
                bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]
        );

        long combinedHash = hash1;
        for (int i = 0; i < numHashFunctions; i++) {
            indices[i] = (combinedHash & Long.MAX_VALUE) % bitmapLength;
            combinedHash += hash2;
        }

        return indices;
    }

    @Override
    public void put(String bloom, String value) {
        for (long index : getOffset(value)) {
            redisOperation.setBit(bloom, index, true);
        }
    }

    @Override
    public Boolean contains(String bloom, String value) {
        int count = 0;

        for (long index : getOffset(value)) {
            Boolean exist = redisOperation.getBit(bloom, index);

            if (!exist) {
                break;
            } else {
                if (++count == numHashFunctions) {
                    return true;
                }
            }
        }

        return false;
    }
}
