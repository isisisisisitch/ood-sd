package ca.bytetube.ood._08_pizza._factory_decorator;

public abstract class BasePizza implements Pizza {
    protected Size size;

    public BasePizza(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }
}
