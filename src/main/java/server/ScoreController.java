package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.entity.Score;
import server.entity.User;
import server.repositories.ScoreRepository;
import server.repositories.UserRepository;

import java.util.Map;

@RestController
public class ScoreController {
    @Autowired
    ScoreRepository scoreRepository;

    @PutMapping("/score/update")
    public Score register(@RequestBody Map<String, String> body){
        int userId = Integer.parseInt(body.get("userId"));
        int points = Integer.parseInt(body.get("points"));

        Score s = scoreRepository.findByUserId(userId);
        s.setPoints(s.getPoints() + points);
        return scoreRepository.save(s);
    }
}
