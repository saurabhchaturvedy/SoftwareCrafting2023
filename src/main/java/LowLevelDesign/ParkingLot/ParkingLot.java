package main.java.LowLevelDesign.ParkingLot;

import java.util.List;
import java.util.Map;

public class ParkingLot {

    String name;
    Address address;
    List<ParkingFloor> parkingFloors;
    static ParkingLot parkingLot = null;

    public ParkingLot(String name, Address address, List<ParkingFloor> parkingFloors) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance(String name, Address address, List<ParkingFloor> parkingFloors) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(name, address, parkingFloors);
        }

        return parkingLot;
    }

    public void addFloors(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        ParkingFloor parkingFloor = new ParkingFloor(name, parkingSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloor(ParkingFloor parkingFloor) {
        parkingFloors.remove(parkingFloor);
    }

    public Ticket generateTicket(Vehicle vehicle) {

        ParkingSlot relevantParkingSlot = getRelevantParkingSlot(vehicle);
        if (relevantParkingSlot == null) return null;
        Ticket ticket = printTicket(vehicle, relevantParkingSlot);
        return ticket;
    }

    public static double scanAndPay(Ticket ticket) {
        long currentTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        long duration = (currentTime - ticket.getStartTime()) / 1000;
        return ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
    }

    private Ticket printTicket(Vehicle vehicle, ParkingSlot relevantParkingSlot) {
        return Ticket.createTicket(vehicle, relevantParkingSlot);

    }


    public ParkingSlot getRelevantParkingSlot(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        for (ParkingFloor parkingFloor : parkingFloors) {
            parkingSlot = parkingFloor.getParkingSlot(vehicle);
            if (parkingSlot != null) {
                break;
            }
        }

        return parkingSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getParkingLot() {
        return parkingLot;
    }

    public static void setParkingLot(ParkingLot parkingLot) {
        ParkingLot.parkingLot = parkingLot;
    }

}
