package ca.bytetube.ood._09_packagedeliverycost;

public enum Size {
    SMALL(1.0), MEDIUM(1.5), LARGE(2.0);

    private final double multiplier;

    Size(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
