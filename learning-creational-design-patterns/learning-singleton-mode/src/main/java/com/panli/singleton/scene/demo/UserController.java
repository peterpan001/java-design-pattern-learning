package com.panli.singleton.scene.demo;

/**
 * @author lipan
 * @date 2020-08-31
 */
public class UserController {
    private Logger logger = new Logger();

    public void login(String username, String password) {
        
        // 业务逻辑代码：判断用户名与密码做登陆操作
        logger.log(username + "logined!");
    }
}
