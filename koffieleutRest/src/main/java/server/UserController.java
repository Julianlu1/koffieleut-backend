package server;

import com.google.gson.Gson;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.entity.User;
import server.logic.HashLogic;
import server.repositories.UserRepository;

import java.util.List;
import java.util.Map;

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
        String name = body.get("name");
        String username = body.get("username");
        String password = body.get("password");

        String hashedPassword = hashLogic.hashPassword(password);
        User user = userRepository.save(new User(username,name,hashedPassword));

        return user;
    }

    @GetMapping("/user/all")
    public List<User> index(){
        return userRepository.findAll();
    }


}
