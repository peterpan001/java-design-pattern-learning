package com.panli.singleton.scene.optimize;

/**
 * @author lipan
 * @date 2020-08-31
 */
public class UserController {
    public void login(String username, String password) {

        // 业务逻辑代码：判断用户名与密码做登陆操作
        Logger.getInstance().log(username + "logined!");
    }
}
