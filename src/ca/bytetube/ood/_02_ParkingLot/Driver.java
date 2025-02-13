package ca.bytetube.ood._02_ParkingLot;

public class Driver {
    private int id;
    private Vehicle vehicle;
    private int paymentDue;

    public Driver(int id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
        paymentDue = 0;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getId() {
        return id;
    }

    public int getPaymentDue() {
        return paymentDue;
    }


}
