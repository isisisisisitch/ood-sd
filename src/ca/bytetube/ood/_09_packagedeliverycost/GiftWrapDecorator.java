package ca.bytetube.ood._09_packagedeliverycost;


public class GiftWrapDecorator extends ItemOptionDecorator {
    public GiftWrapDecorator(Package pack) {
        super(pack);
    }

    @Override
    public String getDescription() {
        return pack.getDescription() + ", Gift Wrap";
    }

    @Override
    public double getCost() {
        return pack.getCost() + 3.00 * pack.getSize().getMultiplier();
    }
}
