package server.controller;

import com.google.gson.Gson;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.Response;
import server.entity.Score;
import server.entity.User;
import server.logic.HashLogic;
import server.repositories.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    HashLogic hashLogic = new HashLogic();

    Gson gson = new Gson();

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody Map<String, String> body){

        String username = body.get("username");
        String password = body.get("password");
        String hashedPassword = userRepository.findByUsername(username).getPassword();

        User user;
        boolean isLoggedIn = hashLogic.checkPassword(password,hashedPassword);

        if(isLoggedIn){
            user = userRepository.findByUsername(username);
            return new ResponseEntity(gson.toJson(user), HttpStatus.OK);
        }else{
            Response response = new Response("Gebruikersnaam of Wachtwoord komt niet overeen");
            return new ResponseEntity(gson.toJson(response), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/register")
    public User register(@RequestBody Map<String, String> body){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        String name = body.get("name");
        String username = body.get("username");
        String password = body.get("password");
        int score = 0;
        String hashedPassword = hashLogic.hashPassword(password);
        User user = userRepository.save(new User(randomUUIDString,username,name,hashedPassword,score));

        return user;
    }

    @GetMapping("/user/all")
    public List<User> index(){
        return userRepository.findAll();
    }


    @PutMapping("/user/score/add")
    public User addScore(@RequestBody Map<String, String> body){
        String id = body.get("id");

        User u = userRepository.findById(id);
        u.setScore(u.getScore() +1);
        userRepository.save(u);

        return u;
    }

}
