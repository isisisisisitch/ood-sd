package ca.bytetube.ood._02_ParkingLot;

public class ParkingGarage {
    private ParkingFloor[] parkingFloors;

    public ParkingGarage(int floorCount, int spotPerFloor) {
        parkingFloors = new ParkingFloor[floorCount];
        for (int i = 0; i < floorCount; i++) {
            parkingFloors[i] = new ParkingFloor(spotPerFloor);
        }


    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.parkVehicle(vehicle)) return true;
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.getVehicleSpots(vehicle) != null) {
                floor.removeVehicle(vehicle);
                return true;
            }
        }
        return false;
    }
}
