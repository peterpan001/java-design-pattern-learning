package com.panli.singleton.ager_initialization;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 单例模式：饿汉式/立即加载模式
 * @solution ID生成器
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    /**
     * 私有构造器禁止外部类实例化该类对象
     */
    private IdGenerator() {
    }

    /**
     * 创建私有对象
     */
    private static final IdGenerator instance = new IdGenerator();

    /**
     * 公有方法，获取该类实例对象的唯一途径
     *
     * @return
     */
    public static IdGenerator getInstance() {
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
