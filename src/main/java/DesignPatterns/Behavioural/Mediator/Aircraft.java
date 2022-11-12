package main.java.DesignPatterns.Behavioural.Mediator;

public class Aircraft implements AircraftColleague {

    AircraftMediator mediator;
    String name;

    public Aircraft(AircraftMediator aircraftMediator, String name) {
        this.mediator = aircraftMediator;
        this.name = name;
    }

    @Override
    public void startLanding() {
        String runway = this.mediator.allocateRunwayTo(this);
        if (runway == null) {
            System.out.println("Due to traffic landing of flight " + this.name + " is delayed ");
        } else {
            System.out.println("Flight " + this.name + " is landing on runway " + runway);
        }
    }

    @Override
    public void finishLanding() {
        System.out.println("Flight " + this.name + " has successfully landed on runway ");
        this.mediator.releaseRunwayOccupiedBy(this);
    }
}
