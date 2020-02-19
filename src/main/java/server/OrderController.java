package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.classes.Order;
import server.repositories.OrderRepository;
import server.repositories.UserRepository;

import java.util.List;
import java.util.Map;


@RestController
public class OrderController {

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
        String code = body.get("code");
        return orderRepository.save(new Order(name,location,code));
    }

    @DeleteMapping("/order/delete")
    public void deleteOrder(@RequestBody Map<String, String> body)
    {
        String name = body.get("name");
        String location = body.get("location");
        String code = body.get("code");
    }
}
