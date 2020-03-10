package server.logic;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.dto.OrderDto;
import server.entity.Coffee;
import server.entity.Order;
import server.entity.User;
import server.mock.CoffeeMock;
import server.mock.OrderDtoMock;
import server.mock.OrderMock;
import server.mock.UserMock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderLogicTest {

    OrderLogic orderLogic;

    CoffeeMock coffeeMock = new CoffeeMock();
    OrderMock orderMock = new OrderMock();
    OrderDtoMock orderDtoMock = new OrderDtoMock();
    UserMock userMock = new UserMock();

    @BeforeEach
    void setUp() {
        orderLogic = new OrderLogic();
    }

    @Test
    void createCode() {
        String code = orderLogic.createCode(coffeeMock.getCoffees().get(0).getId(), 1, 1);
        String code2 = orderLogic.createCode(coffeeMock.getCoffees().get(1).getId(), 3, 3);
        String code3 = orderLogic.createCode(coffeeMock.getCoffees().get(2).getId(), 5, 5);

        Assert.assertEquals("0111", code);
        Assert.assertEquals("0233", code2);
        Assert.assertEquals("0355", code3);
    }

    @Test
    void getDtoList() {
        List<OrderDto> orderDtoList = orderLogic.getDtoList(orderMock.getOrderList());
        List<OrderDto> properDtoList = orderDtoMock.getOrderDtoList();

        assertEquals(properDtoList.get(0).getId(), orderDtoList.get(0).getId());
        assertEquals(properDtoList.get(2).getId(), orderDtoList.get(2).getId());
    }

    @Test
    void createOrder() {
        Order createdOrder = orderLogic.createOrder("currentLocation", 1, 1, 1, userMock.getUserList().get(0));

        Assert.assertEquals("currentLocation", createdOrder.getLocation());
        Assert.assertEquals(userMock.getUserList().get(0), createdOrder.getUser());
    }

    @Test
    void createOrderWithoutLocation() {
        Order createdOrder = orderLogic.createOrder("", 1, 1, 1, userMock.getUserList().get(0));

        Assert.assertNull(createdOrder);
    }






}