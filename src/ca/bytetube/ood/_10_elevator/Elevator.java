package ca.bytetube.ood._10_elevator;

public abstract class Elevator {
    protected int currentFloor;
    protected State state;
    protected boolean emergencyStatus = false;
    private DoorState doorState = DoorState.CLOSED;

    protected enum DoorState {
        OPEN,
        CLOSED
    }

    public Elevator(int currentFloor, boolean emergencyStatus) {
        this.currentFloor = currentFloor;
        this.state = State.IDLE;
        this.emergencyStatus = emergencyStatus;
    }


    protected void openDoors() {
        doorState = DoorState.OPEN;
        System.out.println("Doors are OPEN on floor " + currentFloor);
    }

    protected void closeDoors() {
        doorState = DoorState.CLOSED;
        System.out.println("Doors are CLOSED");
    }

    protected void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract void operate();

    public abstract void processEmergency();

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public State getState() {
        return state;
    }

    protected void setState(State state) {
        this.state = state;
    }

    protected void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    protected DoorState getDoorState() {
        return this.doorState;
    }

    protected void setEmergencyStatus(boolean status) {
        this.emergencyStatus = status;
    }
}
