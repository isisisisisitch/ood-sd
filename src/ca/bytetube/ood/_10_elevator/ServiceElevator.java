package ca.bytetube.ood._10_elevator;

import java.util.LinkedList;

public class ServiceElevator extends Elevator {
    private LinkedList<ServiceRequest> serviceQueue;
    public static final int WEIGHT_LIMIT = 10000;

    public ServiceElevator(int currentFloor, boolean emergencyStatus) {
        super(currentFloor, emergencyStatus);
        this.serviceQueue = new LinkedList<>();
    }


    @Override
    public void operate() {
        while (!serviceQueue.isEmpty()) {
            ServiceRequest currRequest = serviceQueue.remove();
            try {
                if (currRequest.getWeight() > WEIGHT_LIMIT) {
                    throw new RuntimeException("Elevator overloaded with weight: " + currRequest.getWeight());
                }

                // move the elevator to the destination floor
                System.out.println(); // Move to the next line after the dots.
                System.out.println("Currently at " + this.getCurrentFloor());
                try {
                    Thread.sleep(1000); // Assuming 1 second to move to the next floor.
                    System.out.print(currRequest.getDirection());
                    for (int i = 0; i < 3; i++) {
                        System.out.print(".");
                        Thread.sleep(500); // Pause for half a second between dots.
                    }
                } catch (InterruptedException e) {
                    // Handle the interrupted exception here.
                    e.printStackTrace();
                }
                this.setCurrentFloor(currRequest.getDestinationFloor());
                this.setState(currRequest.getDirection());
                System.out.println("Arrived at " + this.getCurrentFloor());
                openDoors();
                waitForSeconds(3); // Simulating 3 seconds for loading/unloading.
                closeDoors();

            } catch (RuntimeException e) {
                System.err.println(e.getMessage()); // Prints the error message.
            }
        }
        this.setState(State.IDLE);
        System.out.println("All requests have been fulfilled, elevator is now " + this.getState());
    }

    public void addRequestToQueue(ServiceRequest request) {
        serviceQueue.add(request);
    }

    @Override
    public void processEmergency() {
        serviceQueue.clear();
        this.setCurrentFloor(1);
        this.setState(State.IDLE);
        this.openDoors();
        this.setEmergencyStatus(true);
        System.out.println("Queue cleared, current floor is " + this.getCurrentFloor() + ". Doors are " + this.getDoorState());
    }

}
