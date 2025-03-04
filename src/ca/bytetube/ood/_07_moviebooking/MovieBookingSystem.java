package ca.bytetube.ood._07_moviebooking;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MovieBookingSystem {
    private List<Movie> movies;
    // Key: showId (例如 "S1", "S2")
    // Value: Show对象
    private Map<String, Show> shows;
    // Key: bookingId (例如 "B1", "B2")
    // Value: Booking对象
    private Map<String, Booking> bookings;
    private UserService userService;

    public MovieBookingSystem() {
        this.movies = new ArrayList<>();
        this.shows = new HashMap<>();
        this.bookings = new HashMap<>();
        this.userService = new UserService();
    }

    public User registerUser(String username, String email, String phoneNumber, String password) {
        return userService.registerUser(username, email, phoneNumber, password);
    }

    public Booking createBooking(String userId, String showId, List<Seat> seats) {

        // 1. 参数验证
        if (userId == null || showId == null || seats == null || seats.isEmpty()) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        // 2. 获取用户信息并验证用户状态
        User user = userService.getUserById(userId);
        if (user.getStatus() != UserStatus.ACTIVE) {
            throw new IllegalStateException("User is not active");
        }

        // 3. 获取场次信息
        Show show = shows.get(showId);
        if (show == null) {
            throw new IllegalArgumentException("Show not found");
        }

        // 4. 验证场次时间
        if (show.getShowTime().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Show has already started");
        }

        // 5. 座位验证和预订（使用同步块确保线程安全）
        synchronized (show) {
            // 5.1 检查参数seats中所有座位是否可用
            for (Seat seat : seats) {
                if (!show.isSeatAvailable(seat)) {
                    throw new IllegalStateException(String.format("Seat %d-%d is not available", seat.getRow(), seat.getColumn())
                    );
                }
            }
            // 5.2 预订参数seats中的所有座位
            try {
                for (Seat seat : seats) {
                    if (!show.bookSeat(seat)) {
                        // 如果预订失败，需要回滚之前预订的座位
                        rollbackBookedSeats(show, seats, seat);
                        throw new IllegalStateException("Failed to book seat");
                    }
                }
            } catch (Exception e) {
                // 发生任何异常都需要回滚
                rollbackBookedSeats(show, seats, null);
                throw e;
            }
        }

        // 6. 创建订单
        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingId, user, show, seats);

        // 7. 保存订单
        bookings.put(bookingId, booking);

        // 8. 更新用户订单历史
        user.addBooking(booking);

        return booking;
    }

    // 回滚已预订的座位
    private void rollbackBookedSeats(Show show, List<Seat> allSeats, Seat failedSeat) {
        for (Seat seat : allSeats) {
            if (seat.equals(failedSeat)) {
                break; // 到达失败的座位时停止
            }
            show.releaseSeat(seat);
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addShow(Movie movie, Show show) {
        movie.addShow(show);
        shows.put(show.getId(), show);
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }


    public boolean makePayment(String bookingId, PaymentMethod method) {
        Booking booking = bookings.get(bookingId);
        if (booking == null) {
            throw new IllegalArgumentException("Booking not found");
        }

        Payment payment = new Payment(booking.getTotalAmount(), method);
        boolean success = payment.process();

        if (success) {
            booking.setStatus(BookingStatus.CONFIRMED);
            booking.setPayment(payment);
        }

        return success;
    }

    private String generateBookingId() {
        return UUID.randomUUID().toString();
    }


}
