package com.panli.builder.scene_2;

/**
 * @author lipan
 * @date 2020-09-06
 * @desc 测试
 */
public class Main {

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig("dbConnectionPool");
        config.setMaxTotal(16);
        config.setMaxIdle(8);
    }
}
