package ca.bytetube.ood._07_moviebooking;

public enum PaymentStatus {
    PENDING("pending"),
    SUCCESS("payment success"),
    FAILED("payment failure"),
    REFUNDED("refunded");

    private String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
