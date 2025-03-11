package ca.bytetube.ood._09_packagedeliverycost;



public class BasePackage implements Package {
    private final Size size;
    private final DeliverySpeed deliverySpeed;

    public BasePackage(Size size, DeliverySpeed deliverySpeed) {
        this.size = size;
        this.deliverySpeed = deliverySpeed;
    }

    @Override
    public String getDescription() {
        return "Package (" + size + ", " + deliverySpeed + ")";
    }

    @Override
    public double getCost() {
        return deliverySpeed.getCost() * size.getMultiplier();
    }

    @Override
    public Size getSize() {
        return size;
    }
}
