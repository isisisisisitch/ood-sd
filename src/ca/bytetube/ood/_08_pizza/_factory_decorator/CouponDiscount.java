package ca.bytetube.ood._08_pizza._factory_decorator;

public class CouponDiscount implements DiscountStrategy {
    private final Coupon coupon;

    public CouponDiscount(Coupon coupon) {
        this.coupon = coupon;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        if (!coupon.isValid()) {
            return originalPrice;
        }

        if (coupon.isPercentage()) {
            return originalPrice * (100 - coupon.getDiscountAmount()) / 100;
        } else {
            return Math.max(0, originalPrice - coupon.getDiscountAmount());
        }
    }

    @Override
    public String getDescription() {
        return "Coupon Discount (" + coupon.getCode() + ")";
    }
}

