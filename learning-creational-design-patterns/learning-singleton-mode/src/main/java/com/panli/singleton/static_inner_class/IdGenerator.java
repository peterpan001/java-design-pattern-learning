package com.panli.singleton.static_inner_class;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 单例模式：静态内部类
 * @solution id生成器
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    /**
     * 私有构造器，禁止外部类实例化该类对象
     */
    private IdGenerator() {
    }

    /**
     * 私有静态内部类，实例化该类对象
     */
    private static class SingletonHolder {
        private static final IdGenerator instance = new IdGenerator();
    }

    /**
     * 公有方法，获取该类对象的唯一途径
     *
     * @return
     */
    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
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
