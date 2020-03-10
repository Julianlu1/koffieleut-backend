package server.logic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import server.Response;
import server.dto.OrderDto;
import server.entity.Order;
import server.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OrderLogic {
    public String createCode(int coffeeId, int strength, int milk){
        StringBuilder generatedCode = new StringBuilder();

        if(coffeeId < 10){
            generatedCode.append(0);
        }
        generatedCode.append(coffeeId);
        generatedCode.append(strength);
        generatedCode.append(milk);

        return generatedCode.toString();
    }

    public List<OrderDto> getDtoList(List<Order> orders) {
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        for(Order order: orders){
            orderDtoList.add(new OrderDto(order));
        }
        return orderDtoList;
    }

    public Order createOrder(String location, int strength, int milk, int coffeeId, User user) {
        String code = createCode(coffeeId, strength, milk);

        if(location == ""){
            return null;
        }else{
            return new Order(user, location,code);
        }
    }
}
