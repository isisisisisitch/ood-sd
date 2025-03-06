package ca.bytetube.ood._08_pizza._factory_decorator;

public enum MembershipLevel {
    NONE(0),
    BRONZE(5),
    SILVER(10),
    GOLD(15);

    private final int discountPercentage;

    MembershipLevel(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountMultiplier() {
        return (100 - discountPercentage) / 100.0;
    }
}
