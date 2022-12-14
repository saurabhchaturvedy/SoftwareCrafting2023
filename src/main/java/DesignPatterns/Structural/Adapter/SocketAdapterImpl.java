package main.java.DesignPatterns.Structural.Adapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volt get10Volts() {
        Volt voltage = getStandardVoltage();
        return convertToBatteryVoltage(voltage, 22);
    }

    private Volt convertToBatteryVoltage(Volt voltage, int i) {
        return new Volt(voltage.getVolts() / i);
    }
}
