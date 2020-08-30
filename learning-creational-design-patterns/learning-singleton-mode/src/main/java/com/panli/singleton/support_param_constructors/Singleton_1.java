package com.panli.singleton.support_param_constructors;

/**
 * @author lipan
 * @date 2020-08-30
 * @desc 解决单例不支持有参的构造函数
 */
public class Singleton_1 {

    /**
     * 声明私有的实例对象
     */
    private static Singleton_1 instance = null;
    private final int paramA;
    private final int paramB;

    /**
     * 私有的有参构造函数
     * @param paramA
     * @param paramB
     */
    private Singleton_1(int paramA, int paramB){
        this.paramA = paramA;
        this.paramB = paramB;
    }

    /**
     * 公有方法，获取该类的唯一途径
     * @return
     */
    public static Singleton_1 getInstance(){
        if(instance == null){
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }

    /**
     * 调用公有的init()，初始化有参的私有构造对象
     * @param paramA
     * @param paramB
     * @return
     */
    public synchronized static Singleton_1 init(int paramA, int paramB){
        if(instance!=null){
            throw new RuntimeException("Singleton_1 has been created.");
        }
        instance = new Singleton_1(paramA, paramB);
        return instance;
    }
}
