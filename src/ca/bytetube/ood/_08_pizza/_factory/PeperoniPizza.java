package ca.bytetube.ood._08_pizza._factory;

public class PeperoniPizza extends Pizza {
    public PeperoniPizza(Size size) {
        super(size);
        this.name = "Peperoni Pizza";
    }

    @Override
    public double getBasePrize() {
        switch (size) {
            case SMALL:
                return 9.99;
            case MEDIUM:
                return 10.99;
            case LARGE:
                return 12.99;
            default:
                return 0;
        }
    }
}
