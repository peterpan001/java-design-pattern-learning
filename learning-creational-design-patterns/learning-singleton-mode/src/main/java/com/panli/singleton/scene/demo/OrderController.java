package com.panli.singleton.scene.demo;

/**
 * @author lipan
 * @date 2020-08-31
 */
public class OrderController {
    private Logger logger = new Logger();

    public void createOrder(OrderVo order) {
        // 业务代码逻辑，创建订单
        logger.log("created an order:" + order.toString());
    }

}
