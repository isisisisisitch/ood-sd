package ca.bytetube.ood._09_packagedeliverycost;

public enum MembershipLevel {
    NONE(0), SILVER(5), GOLD(10);

    private final int discountPercentage;

    MembershipLevel(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountMultiplier() {
        return (100 - discountPercentage) / 100.0;
    }
}
