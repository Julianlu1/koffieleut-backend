package server.logic;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashLogicTest {

    HashLogic hashLogic;

    @BeforeEach
    void setUp() {
        hashLogic = new HashLogic();
    }

    @Test
    void checkHashedPassword() {
        String password = "myPassword";
        String hashedPassword = hashLogic.hashPassword(password);

        boolean passwordCorrect = hashLogic.checkPassword(password, hashedPassword);

        Assert.assertTrue(passwordCorrect);
    }

    @Test
    void checkWrongPassword() {
        String correctPassword = "myPassword";
        String wrongPassword = "myWrongPassword";
        String hashedPassword = hashLogic.hashPassword(correctPassword);

        boolean passwordCorrect = hashLogic.checkPassword(wrongPassword, hashedPassword);

        Assert.assertFalse(passwordCorrect);
    }
}