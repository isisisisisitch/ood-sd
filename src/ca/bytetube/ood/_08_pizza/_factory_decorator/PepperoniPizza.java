package ca.bytetube.ood._08_pizza._factory_decorator;

public class PepperoniPizza extends BasePizza {
    public PepperoniPizza(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "Pepperoni Pizza (" + size + ")";
    }

    @Override
    public double getCost() {
        return switch (size) {
            case SMALL -> 9.99;
            case MEDIUM -> 11.99;
            case LARGE -> 13.99;
        };
    }
}
