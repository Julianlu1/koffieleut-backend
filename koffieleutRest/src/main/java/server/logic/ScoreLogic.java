package server.logic;

import server.entity.User;

public class ScoreLogic {
    public User addScore(User user) {
        int newScore = user.getScore() + 100;
        user.setScore(newScore);
        return user;
    }
}
