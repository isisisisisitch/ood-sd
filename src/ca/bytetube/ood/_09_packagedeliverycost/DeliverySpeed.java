package ca.bytetube.ood._09_packagedeliverycost;

public enum DeliverySpeed {
    SAME_DAY(3), NEXT_DAY(10), TWO_DAY(15);

    private final int cost;

    DeliverySpeed(int cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
