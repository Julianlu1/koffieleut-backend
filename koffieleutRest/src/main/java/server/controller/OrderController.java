package server.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.Response;
import server.dto.OrderDto;
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

    Gson gson = new Gson();

    @GetMapping("/order/all")
    public List<OrderDto> index(){
        return orderLogic.getDtoList(orderRepository.findAll());
    }

    @PostMapping("/order/create")
    public Object createOrder(@RequestBody Map<String, String> body){
        String location = body.get("location");
        int strength = Integer.parseInt(body.get("strength"));
        int milk = Integer.parseInt(body.get("milk"));
        int coffeeId = Integer.parseInt(body.get("coffeeId"));
        String userId = body.get("userId");

        Order currentOrder = orderLogic.createOrder(location, strength, milk, coffeeId, userRepository.findById(userId));

        if(currentOrder == null){
            return new ResponseEntity<String>(gson.toJson(new Response("Locatie niet ingevuld")), HttpStatus.I_AM_A_TEAPOT);
        }
        else{
            return orderRepository.save(currentOrder);
        }
    }

    @DeleteMapping("/order/delete")
    public Order deleteOrder(@RequestBody Map<String,String> body){
        int id = Integer.parseInt(body.get("orderId"));
        Order order = orderRepository.findOne(id);
        orderRepository.delete(order);
        return order;
    }

}
