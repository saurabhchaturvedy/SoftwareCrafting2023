package main.java.LowLevelDesign.ParkingLot;

public enum ParkingSlotType {


    SMALL {
        @Override
        public double getPriceForParking(long duration) {
            return 30.0;
        }
    }, COMPACT {
        @Override
        public double getPriceForParking(long duration) {
            return 50;
        }
    }, MEDIUM {
        @Override
        public double getPriceForParking(long duration) {
            return 100;
        }
    }, LARGE {
        @Override
        public double getPriceForParking(long duration) {
            return 150;
        }
    };


    public abstract double getPriceForParking(long duration);
}
