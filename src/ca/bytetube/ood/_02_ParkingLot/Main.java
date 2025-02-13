package ca.bytetube.ood._02_ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingGarage parkingGarage = new ParkingGarage(1, 2);
        ParkingSystem system = new ParkingSystem(parkingGarage, 10);
        Driver driver1 = new Driver(1, new Car(1));
        Driver driver2 = new Driver(1, new Limo(2));
        Driver driver3 = new Driver(1, new SemiTruck(3));

        System.out.println(system.parkVehicle(driver1));
        System.out.println(system.parkVehicle(driver2));
        System.out.println(system.parkVehicle(driver3));

        System.out.println(system.removeVehicle(driver1));
        System.out.println(system.removeVehicle(driver2));
        System.out.println(system.removeVehicle(driver3));

    }
}
