package ca.bytetube.ood._08_pizza._factory;

public class CheesePizza extends Pizza {
    public CheesePizza(Size size) {
        super(size);
        this.name = "Cheese Pizza";
    }

    @Override
    public double getBasePrize() {
        switch (size) {
            case SMALL:
                return 8.99;
            case MEDIUM:
                return 9.99;
            case LARGE:
                return 11.99;
            default:
                return 0;
        }

    }
}
