package main.java.DesignPatterns.Behavioural.Mediator;

public class Main {

    public static void main(String[] args) {

        Runway runway = new Runway("1 A");
        AircraftMediator aircraftMediator = new AirTrafficControl();
        aircraftMediator.registerRunway(runway);
        Aircraft aircraft1 = new Aircraft(aircraftMediator, "67728E");
        aircraft1.startLanding();
        Aircraft aircraft = new Aircraft(aircraftMediator, "6328E");
        aircraft.startLanding();
        aircraft.finishLanding();


    }
}
