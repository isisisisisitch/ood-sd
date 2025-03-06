package ca.bytetube.ood._08_pizza._factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    Size size;
    List<Topping> toppings;
    String name;
//    double prize;

    public Pizza(Size size) {
        this.size = size;
        toppings = new ArrayList<>();
    }

    public double calTotalPrice() {
        double total = getBasePrize();
        for (Topping t : toppings) {
            total += t.getPrice();
        }

        return total;
    }

    public abstract double getBasePrize();

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
}
