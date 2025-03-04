package ca.bytetube.ood._07_moviebooking;

public enum BookingStatus {
    PENDING("unpaid"),
    CONFIRMED("confirmed"),
    CANCELLED("canceled"),
    COMPLETED("completed");

    private String description;

    BookingStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
