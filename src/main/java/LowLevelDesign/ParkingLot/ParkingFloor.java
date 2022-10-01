package main.java.LowLevelDesign.ParkingLot;

import java.util.Map;

public class ParkingFloor {

    String name;
    Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    public ParkingFloor(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.name = name;
        this.parkingSlots = parkingSlots;
    }


    public ParkingSlot getParkingSlot(Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        ParkingSlotType parkingSlotType = getParkingSlotType(type);
        Map<String, ParkingSlot> validParkingSlots = parkingSlots.get(parkingSlotType);
        ParkingSlot parkingSlot = null;
        for (Map.Entry<String, ParkingSlot> slot : validParkingSlots.entrySet()) {
            if (slot.getValue().isAvailable()) {
                parkingSlot = slot.getValue();
                parkingSlot.addVehicle(vehicle);
                break;
            }
        }
        return parkingSlot;
    }


    public ParkingSlotType getParkingSlotType(VehicleType vehicleType) {
        if (vehicleType == VehicleType.TWO_WHEELER) return ParkingSlotType.SMALL;
        else if (vehicleType == VehicleType.SEDAN || vehicleType == VehicleType.HATCH_BACK) {
            return ParkingSlotType.COMPACT;
        } else if (vehicleType == VehicleType.SUV) {
            return ParkingSlotType.MEDIUM;
        } else {
            return ParkingSlotType.LARGE;
        }
    }
}
