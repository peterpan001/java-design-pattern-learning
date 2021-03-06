**单例模式**

1.`定义`
    
    一个类只允许创建一个对象（或者说实例），那么这个类就为单例类；这种设计模式即为单例设计模式，即单例模式。
    
2.`单例用处`

    业务概念上，数据在系统中只应该保存一份，比较适合设计为单例类。

3.`单例的关注点`

    构造函数需要是private访问权限，这样才能避免外部通过new创建；
    考虑对象创建时的线程安全问题；
    考虑是否支持延迟加载；
    考虑getInstance()性能是否高（是否加锁）。

**单例实现**

1.`饿汉式`
    
    饿汉方式实现为：在类加载期间，就已经将instance静态实例初始化好了，故饿汉式为线程安全的。不过其不支持延迟加载实例。
    
2.`懒汉式`

    相比于饿汉式，其支持延迟加载，不过其频繁的加锁、释放锁、已经对象锁并发度比较低，频繁调用易产生性能瓶颈。
    
3.`双重检查锁机制`

    弥补了懒汉式的缺点，即支持延迟加载，又支持高并发；只要instance实例对象创建后，获取实例对象方法就不会再走加锁逻辑，解决了懒汉式并发度低的问题。
    
4.`静态内部类`

    利用Java语言特性（静态内部类）实现单例设计模式，既支持延迟加载有支持高并发，且实现方式比双重检查锁机制简单。
    
5.`枚举`

    实现方式简单，通过Java语言枚举类型本身的特性，保证了实例创建的线程安全性与实例的唯一性。
    
**单例存在的问题**

1.单例对OOP特性的支持不友好（违背了基于接口而非实现的原则）；

2.单例会隐藏类之间的依赖关系；

3.单例对代码的扩展性不友好；

4.单例对代码的可测试性不友好；

5.单例不支持有参的构造函数；


