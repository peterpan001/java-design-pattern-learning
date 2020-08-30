package com.panli.singleton.support_param_constructors;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 通过配置文件方式解决单例不支持有参的构造函数
 */
public class Singleton_2 {

    private static Singleton_2 instance;
    private final int paramA;
    private final int paramB;

    private Singleton_2() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public static synchronized Singleton_2 getInstance() {
        if (instance == null) {
            instance = new Singleton_2();
        }
        return instance;
    }
}

class Config {
    public static final int PARAM_A = 123;
    public static final int PARAM_B = 456;
}