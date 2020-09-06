package com.panli.factory.scene_di_container;

/**
 * @author lipan
 * @date 2020-09-04
 */
public class RateLimiter {
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test(){
        System.out.println("Hello World!");
    }

    // ...
}
