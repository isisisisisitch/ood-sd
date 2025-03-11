package ca.bytetube.ood._09_packagedeliverycost;

public class SignatureRequiredDecorator extends ItemOptionDecorator {
    public SignatureRequiredDecorator(Package pack) {
        super(pack);
    }

    @Override
    public String getDescription() {
        return pack.getDescription() + ", Signature Required";
    }

    @Override
    public double getCost() {
        return pack.getCost();
    }
}
