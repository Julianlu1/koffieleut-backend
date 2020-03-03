package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.OrderDto;
import server.entity.Order;
import server.entity.User;
import server.logic.OrderLogic;
import server.repositories.OrderRepository;
import server.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class OrderController {
    OrderLogic orderLogic = new OrderLogic();

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/order/all")
    public List<OrderDto> index(){
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();

        for(Order order: orderRepository.findAll()){
            orderDtoList.add(new OrderDto(order));
        }

        return orderDtoList;
    }

    @PostMapping("/order/create")
    public Order createOrder(@RequestBody Map<String, String> body){
        String location = body.get("location");
        int strength = Integer.parseInt(body.get("strength"));
        int milk = Integer.parseInt(body.get("milk"));
        int coffeeId = Integer.parseInt(body.get("coffeeId"));
        int userId = Integer.parseInt(body.get("userId"));

        User currentUser = userRepository.findOne(userId);
        String code = orderLogic.createCode(coffeeId, strength, milk);

        return orderRepository.save(new Order(currentUser, location,code));
    }

    @DeleteMapping("/order/delete")
    public Order deleteOrder(@RequestBody Map<String,String> body){
        int id = Integer.parseInt(body.get("orderId"));
        Order order = orderRepository.findOne(id);
        orderRepository.delete(order);
        return order;
    }

}