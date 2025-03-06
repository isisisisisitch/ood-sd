package ca.bytetube.ood._08_pizza._factory_decorator;

public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
    String getDescription();
}
