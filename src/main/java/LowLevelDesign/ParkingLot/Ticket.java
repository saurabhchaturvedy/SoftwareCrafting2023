package main.java.LowLevelDesign.ParkingLot;

public class Ticket {

    private String ticketId;
    private long startTime;
    private long endTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        return new Ticket.Builder(vehicle, parkingSlot).startTime(System.currentTimeMillis()).ticketId(vehicle.getRegistrationNumber() + System.currentTimeMillis()).build();
    }

    private Ticket(Builder builder) {

        this.ticketId = builder.ticketId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.vehicle = builder.vehicle;
        this.parkingSlot = builder.parkingSlot;

    }

    public String getTicketId() {
        return ticketId;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public static class Builder {
        private String ticketId;
        private long startTime;
        private long endTime;
        private Vehicle vehicle;
        private ParkingSlot parkingSlot;

        Builder(Vehicle vehicle, ParkingSlot parkingSlot) {
            this.vehicle = vehicle;
            this.parkingSlot = parkingSlot;
        }

        Builder ticketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        Builder startTime(long startTime) {
            this.startTime = startTime;
            return this;
        }

        Builder endTime(long endTime) {
            this.endTime = endTime;
            return this;
        }

        Ticket build() {
            return new Ticket(this);
        }

    }
}
