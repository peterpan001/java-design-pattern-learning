package com.panli.singleton.multi_instance_mode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 多例模式（指定个数的实例模式）
 */
public class BackendServer {

    private long serverNo;
    private String serverAddress;

    private static final int SERVER_COUNT = 3;
    private static final Map<Long, BackendServer> serverInstances = new HashMap<Long, BackendServer>();

    static {
        serverInstances.put(1L, new BackendServer(1L, "192.168.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.168.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.168.22.140:8080"));
    }

    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    public BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT) + 1;
        return serverInstances.get(no);
    }
}
