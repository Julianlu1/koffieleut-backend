package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import server.classes.Order;
import server.repositories.OrderRepository;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order/all")
    public List<Order> index(){
        return orderRepository.findAll();
    }

}
