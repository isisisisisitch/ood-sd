package ca.bytetube.ood._08_pizza._factory;

public class PizzaFactory {

    public Pizza createPizza(String type, Size size) {
        switch (type.toLowerCase()) {
            case "cheese":
                return new CheesePizza(size);
            case "peperoni":
                return new PeperoniPizza(size);
            default:
                throw new IllegalArgumentException("pizza type not found!");

        }

    }
}
