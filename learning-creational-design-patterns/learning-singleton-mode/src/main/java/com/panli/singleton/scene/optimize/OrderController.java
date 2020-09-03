package com.panli.singleton.scene.optimize;

/**
 * @author lipan
 * @date 2020-08-31
 */
public class OrderController {

    public void createOrder(OrderVo order) {
        Logger.getInstance().log("Created an order:" + order.toString());
    }
}
