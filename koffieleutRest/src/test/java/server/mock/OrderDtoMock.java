package server.mock;

import server.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderDtoMock {
    OrderMock orderMock = new OrderMock();

    public List<OrderDto> getOrderDtoList() {
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        orderDtoList.add(new OrderDto(orderMock.getOrderList().get(0)));
        orderDtoList.add(new OrderDto(orderMock.getOrderList().get(1)));
        orderDtoList.add(new OrderDto(orderMock.getOrderList().get(2)));
        return orderDtoList;
    }
}
