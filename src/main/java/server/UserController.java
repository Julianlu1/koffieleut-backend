package server;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.classes.Order;
import server.classes.User;
import server.repositories.UserRepository;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/login")
    public User login(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        User user = userRepository.findByUsernameAndPassword(username,password);

        return user;
    }

    @PostMapping("/user/register")
    public User register(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        User user = userRepository.findByUsernameAndPassword(username,password);

        return user;
    }

    @GetMapping("/user/all")
    public List<User> index(){
        return userRepository.findAll();
    }


    public String hashPassword(String passwordPlaintext) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(passwordPlaintext, salt);
    }

    public  boolean checkPassword(String password_plaintext, String storedHash) {
        boolean passwordVerified = false;

        if(null == storedHash || !storedHash.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid hash provided for comparison");

        passwordVerified = BCrypt.checkpw(password_plaintext, storedHash);

        return(passwordVerified);
    }
}
