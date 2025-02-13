package ca.bytetube.ood._02_ParkingLot;

import java.util.Calendar;
import java.util.Map;

public class ParkingSystem {
    private ParkingGarage parkingGarage;
    //Map<Integer, Integer>:key:driverId, value:startTime
    private Map<Integer, Integer> timeParked;
    private int hourRate;

    public ParkingSystem(ParkingGarage parkingGarage, int hourRate) {
        this.parkingGarage = parkingGarage;
        this.hourRate = hourRate;
    }

    public boolean parkVehicle(Driver driver) {
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        boolean isParked = parkingGarage.parkVehicle(driver.getVehicle());
        if (isParked) {
            timeParked.put(driver.getId(), currentHour);
        }
        return isParked;
    }

    public boolean removeVehicle(Driver driver) {

//        if (!timeParked.containsKey(driver.getId())) {
//            return false;
//
//        }
//        timeParked.remove(driver.getId());
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        return parkingGarage.removeVehicle(driver.getVehicle());
    }

}
