package server;

import logica.CoffeeLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.classes.Order;
import server.repositories.OrderRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;


@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    CoffeeLogic coffeeLogic;

    @GetMapping("/order/all")
    public List<Order> index(){
        return orderRepository.findAll();
    }

    @PostMapping("/order/create")
    public Order create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String location = body.get("location");
        String code = body.get("code");
        return orderRepository.save(new Order(name,location,code));
    }
}
