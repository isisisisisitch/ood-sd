package ca.bytetube.ood._07_moviebooking;

import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;
    private Payment payment;

    public Booking(String id, User user, Show show, List<Seat> seats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.PENDING;
    }

    public double getTotalAmount() {
        return show.getPrice() * seats.size();
    }

    public void confirmBooking() {
        if (this.status == BookingStatus.PENDING) {
            this.status = BookingStatus.CONFIRMED;
        } else {
            throw new IllegalStateException("Booking cannot be confirmed");
        }
    }

    public void cancelBooking() {
        if (this.status == BookingStatus.PENDING ||
                this.status == BookingStatus.CONFIRMED) {
            this.status = BookingStatus.CANCELLED;
            // 释放座位
            for (Seat seat : seats) {
                show.releaseSeat(seat);
            }
        } else {
            throw new IllegalStateException("Booking cannot be cancelled");
        }
    }

    public void completeBooking() {
        if (this.status == BookingStatus.CONFIRMED) {
            this.status = BookingStatus.COMPLETED;
        } else {
            throw new IllegalStateException("Booking cannot be completed");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


}
