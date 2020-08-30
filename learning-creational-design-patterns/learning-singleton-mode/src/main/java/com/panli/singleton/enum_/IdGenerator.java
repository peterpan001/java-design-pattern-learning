package com.panli.singleton.enum_;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 单例模式：枚举方式实现
 * @solution id生成器
 */
public enum IdGenerator {
    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
