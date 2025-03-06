package ca.bytetube.ood._08_pizza._factory_decorator;

public class CheesePizza extends BasePizza {
    public CheesePizza(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "Cheese Pizza (" + size + ")";
    }

    @Override
    public double getCost() {
        return switch (size) {
            case SMALL -> 8.99;
            case MEDIUM -> 10.99;
            case LARGE -> 12.99;
        };
    }
}

