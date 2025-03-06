package ca.bytetube.ood._08_pizza._factory;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        PizzaFactory factory = new PizzaFactory();

        Pizza cheesePizza = factory.createPizza("cheese", Size.LARGE);
        cheesePizza.addTopping(new Topping("extra cheese", 1.5));
        cheesePizza.addTopping(new Topping("sugar", 0.5));
        order.addPizza(cheesePizza);
        Pizza peperoniPizza = factory.createPizza("peperoni", Size.MEDIUM);
        peperoniPizza.addTopping(new Topping("Mushroom", 1.00));
        order.addPizza(peperoniPizza);

        System.out.println("total price is " + order.getTotalPrice());//25.48

    }
}
