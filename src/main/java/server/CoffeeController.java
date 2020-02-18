package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.classes.Coffee;
import server.repositories.CoffeeRepository;

import java.util.List;
import java.util.Map;


@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

    @GetMapping("/coffee/all")
    public List<Coffee> index(){
        return coffeeRepository.findAll();
    }

    @PostMapping("/coffee/create")
    public Coffee create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        return coffeeRepository.save(new Coffee(name));
    }
}