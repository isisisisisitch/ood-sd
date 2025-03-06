package ca.bytetube.ood._08_pizza._factory_decorator;

import java.time.LocalDate;

public class Coupon {
    private String code;
    private double discountAmount;
    private boolean isPercentage;
    private LocalDate expiryDate;
    private boolean used;

    public Coupon(String code, double discountAmount, boolean isPercentage, LocalDate expiryDate) {
        this.code = code;
        this.discountAmount = discountAmount;
        this.isPercentage = isPercentage;
        this.expiryDate = expiryDate;
        this.used = false;
    }

    public boolean isValid() {
        return !used && LocalDate.now().isBefore(expiryDate);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean isPercentage() {
        return isPercentage;
    }

    public void setPercentage(boolean percentage) {
        isPercentage = percentage;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }


}
