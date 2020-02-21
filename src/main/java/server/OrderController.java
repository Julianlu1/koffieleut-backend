package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.entity.Order;
import server.logic.OrderLogic;
import server.repositories.OrderRepository;
import server.repositories.UserRepository;

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
    public List<Order> index(){
        return orderRepository.findAll();
    }

    @PostMapping("/order/create")
    public Order createOrder(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String location = body.get("location");
        int strength = Integer.parseInt(body.get("strength"));
        int milk = Integer.parseInt(body.get("milk"));
        int coffeeId = Integer.parseInt(body.get("coffeeId"));

        //tijdelijke value
        int userId = 1;

        String code = orderLogic.createCode(coffeeId, strength, milk);

        return orderRepository.save(new Order(userId, name,location,code));
    }

    @DeleteMapping("/order/delete/{orderId}")
    public Order deleteOrder(@RequestBody Map<String,String> body){
        int id = Integer.parseInt(body.get("orderId"));
        Order order = orderRepository.findOne(id);
        orderRepository.delete(order);
        return order;
    }
}
