package com.panli.builder.builder_pattern;

/**
 * @author lipan
 * @date 2020-09-06
 * @desc 测试
 */
public class Main {
    public static void main(String[] args) {

        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbPoolConfig")
                .setMaxTotal(16)
                .setMaxIdle(8)
                .setMinIdle(12)
                .build();
    }
}
