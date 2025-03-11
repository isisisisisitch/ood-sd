package ca.bytetube.ood._09_packagedeliverycost;


public abstract class ItemOptionDecorator implements Package {
    protected Package pack;

    public ItemOptionDecorator(Package pack) {
        this.pack = pack;
    }

    @Override
    public Size getSize() {
        return pack.getSize();
    }
}
