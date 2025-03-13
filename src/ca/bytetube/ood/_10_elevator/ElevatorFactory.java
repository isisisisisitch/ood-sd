package ca.bytetube.ood._10_elevator;

public class ElevatorFactory {

    public Elevator createElevator(ElevatorType type) {
        return switch (type) {
            case PASSENGER -> new PassengerElevator(1, false);
            case SERVICE -> new ServiceElevator(1, false);
            default -> throw new IllegalArgumentException("Unknown criteria.");
        };
    }
}
