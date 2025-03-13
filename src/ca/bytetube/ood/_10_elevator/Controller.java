package ca.bytetube.ood._10_elevator;

public class Controller {
    private ElevatorFactory factory;
    private PassengerElevator passengerElevator;
    private ServiceElevator serviceElevator;

    public Controller(ElevatorFactory factory) {
        this.factory = factory;
        this.passengerElevator = (PassengerElevator) factory.createElevator(ElevatorType.PASSENGER);
        this.serviceElevator = (ServiceElevator) factory.createElevator(ElevatorType.SERVICE);
    }

    public void sendPassengerUpRequests(Request request) {
        this.passengerElevator.addUpRequest(request);
    }

    public void sendPassengerDownRequests(Request request) {
        this.passengerElevator.addDownRequest(request);
    }

    public void sendServiceRequest(ServiceRequest request) {
        this.serviceElevator.addRequestToQueue(request);
    }

    public void handlePassengerRequests() {
        this.passengerElevator.operate();

    }

    public void handleServiceRequests() {
        this.serviceElevator.operate();
    }

    public void handleEmergency() {
        passengerElevator.processEmergency();
        serviceElevator.processEmergency();
    }
}
