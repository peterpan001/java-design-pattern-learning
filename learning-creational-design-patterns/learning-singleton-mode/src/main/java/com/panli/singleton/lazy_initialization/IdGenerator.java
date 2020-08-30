package com.panli.singleton.lazy_initialization;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 单例模式：懒汉式/懒加载
 * @solution id生成器
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    /**
     * 私有构造器，禁止外部类初始化该类对象
     */
    private IdGenerator() {
    }

    /**
     * 创建私有对象，不直接初始化
     */
    private static IdGenerator instance;

    /**
     * 公有方法，获取该类对象的唯一途径
     *
     * @return
     */
    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    /**
     * 类对象方法
     *
     * @return
     */
    public long getId() {
        return id.incrementAndGet();
    }
}
