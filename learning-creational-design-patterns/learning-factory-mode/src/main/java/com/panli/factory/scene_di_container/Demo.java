package com.panli.factory.scene_di_container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipan
 * @date 2020-09-06
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");

        rateLimiter.test();

        //...
    }
}
