package ca.bytetube.ood._07_moviebooking;

public enum PaymentMethod {
    CREDIT_CARD("credit card"),
    DEBIT_CARD("debit card"),
    PAYPAL("paypal"),
    ZELLE("zelle");

    private String description;

    PaymentMethod(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
