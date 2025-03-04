package ca.bytetube.ood._07_moviebooking;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String id;
    private String name;
    private List<Seat> seats;

    public Theater(String id, String name) {
        this.id = id;
        this.name = name;
        this.seats = new ArrayList<>();
        initializeSeats();
    }

    private void initializeSeats() {
        // 初始化座位
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                seats.add(new Seat(row, col));
            }
        }
    }
}
