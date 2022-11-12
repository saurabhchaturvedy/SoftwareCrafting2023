package main.java.DesignPatterns.Behavioural.Mediator;

public interface AircraftMediator {

    void registerRunway(Runway runway);
    String allocateRunwayTo(Aircraft aircraft);
    void releaseRunwayOccupiedBy(Aircraft aircraft);
}
