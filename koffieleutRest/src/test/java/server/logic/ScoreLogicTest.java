package server.logic;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import server.entity.User;
import server.mock.UserMock;

import static org.junit.jupiter.api.Assertions.*;

class ScoreLogicTest {

    ScoreLogic scoreLogic = new ScoreLogic();

    UserMock userMock = new UserMock();

    @Test
    void addScore() {
        User currentUser = userMock.getUserList().get(0);

        Assert.assertEquals(100, currentUser.getScore());

        scoreLogic.addScore(currentUser);

        Assert.assertEquals(200, currentUser.getScore());
    }
}