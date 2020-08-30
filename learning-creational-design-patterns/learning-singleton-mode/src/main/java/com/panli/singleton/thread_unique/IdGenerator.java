package com.panli.singleton.thread_unique;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 线程内唯一的单例
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    /**
     * 借助线程安全的ConcurrentHashMap，即可实现线程内唯一的单例模式
     * 其中 key 为线程ID，value为单例对象
     */
    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<Long, IdGenerator>();

    private IdGenerator() {

    }

    public static IdGenerator getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
