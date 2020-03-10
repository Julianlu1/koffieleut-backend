package server.mock;

import server.entity.Coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMock {
    public List<Coffee> getCoffees() {
        List<Coffee> coffeeList = new ArrayList<Coffee>();

        coffeeList.add(new Coffee(1, "Zwarte koffie"));
        coffeeList.add(new Coffee(2, "Capuccino"));
        coffeeList.add(new Coffee(3, "Machiato"));

        return coffeeList;
    }
}
