package com.panli.factory.scene_di_container;

/**
 * @author lipan
 * @date 2020-09-04
 */
public class RedisCounter {
    private String ipAddress;
    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    //....
}
