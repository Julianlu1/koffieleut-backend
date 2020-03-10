package server.mock;

import server.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMock {
    UserMock userMock = new UserMock();

    public List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order(1, userMock.getUserList().get(0), "currentLocation", "0123"));
        orderList.add(new Order(2, userMock.getUserList().get(1), "currentLocation1", "0213"));
        orderList.add(new Order(3, userMock.getUserList().get(2), "currentLocation2", "0321"));
        return orderList;
    }
}
