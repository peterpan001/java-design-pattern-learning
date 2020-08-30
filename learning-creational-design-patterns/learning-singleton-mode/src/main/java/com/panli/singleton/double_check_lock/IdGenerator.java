package com.panli.singleton.double_check_lock;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 单例模式：双重检查锁机制
 * @solution Id生成器
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    /**
     * 私有构造器，禁止外部类实例化该类对象
     */
    private IdGenerator() {

    }

    /**
     * 实例化该类对象
     * 高版本Java对象已经不需要使用volatile关键字，因为Java内部已经将new操作和初始化操作设计为原子操作，避免了重排序问题
     */
    private static IdGenerator instance;

    /**
     * 公有方法，获取该类对象的唯一途径
     *
     * @return
     */
    public static IdGenerator getInstance() { //双重检查锁机制
        if (instance == null) {
            synchronized (IdGenerator.class) { // 锁为类，类级别锁
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
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
