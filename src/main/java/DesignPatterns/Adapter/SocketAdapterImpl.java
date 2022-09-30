package main.java.DesignPatterns.Adapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volt get10Volts() {
        Volt voltage = getVoltage();
        return convertToBatteryVoltage(voltage, 22);
    }

    private Volt convertToBatteryVoltage(Volt voltage, int i) {
        return new Volt(voltage.getVolts() / i);
    }
}
