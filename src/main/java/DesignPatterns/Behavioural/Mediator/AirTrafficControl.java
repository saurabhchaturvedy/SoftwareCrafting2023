package main.java.DesignPatterns.Behavioural.Mediator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AirTrafficControl implements AircraftMediator {

    LinkedList<Runway> runways = new LinkedList<>();
    Map<Aircraft, Runway> aircraftRunwayMap = new HashMap<>();

    @Override
    public void registerRunway(Runway runway) {
        this.runways.add(runway);
    }

    @Override
    public String allocateRunwayTo(Aircraft aircraft) {
        Runway runway = null;
        if (!this.runways.isEmpty()) {
            runway = this.runways.removeFirst();
        }

        return runway == null ? null : runway.getName();
    }

    @Override
    public void releaseRunwayOccupiedBy(Aircraft aircraft) {

        if (this.aircraftRunwayMap.containsKey(aircraft)) {
            Runway runway = this.aircraftRunwayMap.remove(aircraft);
            this.runways.add(runway);
        }
    }
}
