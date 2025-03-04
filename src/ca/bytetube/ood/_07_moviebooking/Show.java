package ca.bytetube.ood._07_moviebooking;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Show {
    private String id;
    private Movie movie;
    private Theater theater;
    private LocalDateTime showTime;
    private double price;
    private Set<Seat> bookedSeats;

    public Show(String id, Movie movie, Theater theater, LocalDateTime showTime, double price) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.showTime = showTime;
        this.price = price;
        this.bookedSeats = new HashSet<>();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(Set<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }



    public synchronized boolean isSeatAvailable(Seat seat) {
        return !bookedSeats.contains(seat);
    }

    public synchronized boolean bookSeat(Seat seat) {
        if (isSeatAvailable(seat)) {
            bookedSeats.add(seat);
            return true;
        }
        return false;
    }

    public void releaseSeat(Seat seat) {
        bookedSeats.remove(seat);
    }

}
