package ca.bytetube.ood._08_pizza._factory_decorator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CouponManager {
    private Map<String, Coupon> coupons = new HashMap<>();

    public void addCoupon(Coupon coupon) {
        coupons.put(coupon.getCode(), coupon);
    }

    public Optional<Coupon> validateCoupon(String code) {
        Coupon coupon = coupons.get(code);
        if (coupon != null && coupon.isValid()) {
            return Optional.of(coupon);
        }
        return Optional.empty();
    }
}
