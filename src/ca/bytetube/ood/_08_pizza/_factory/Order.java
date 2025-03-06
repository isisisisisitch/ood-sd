package ca.bytetube.ood._08_pizza._factory;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas;
    private int orderId;
    private static int orderCounter = 0;

    public Order() {
        pizzas = new ArrayList<>();
        orderId = ++orderCounter;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public double getTotalPrice() {
        return pizzas.stream().mapToDouble(Pizza::calTotalPrice).sum();
    }


}
