package server.logic;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.entity.Coffee;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderLogicTest {

    OrderLogic orderLogic;

    @BeforeEach
    void setUp() {
        orderLogic = new OrderLogic();
    }

    @Test
    void createCode() {
        String code = orderLogic.createCode(getCoffees().get(0).getId(), 1, 1);
        String code2 = orderLogic.createCode(getCoffees().get(1).getId(), 3, 3);
        String code3 = orderLogic.createCode(getCoffees().get(2).getId(), 5, 5);

        Assert.assertEquals("0111", code);
        Assert.assertEquals("0233", code2);
        Assert.assertEquals("0355", code3);
    }

    private List<Coffee> getCoffees(){
        List<Coffee> coffeeList = new ArrayList<Coffee>();

        coffeeList.add(new Coffee(1, "Zwarte koffie"));
        coffeeList.add(new Coffee(2, "Capuccino"));
        coffeeList.add(new Coffee(3, "Machiato"));

        return coffeeList;
    }
}