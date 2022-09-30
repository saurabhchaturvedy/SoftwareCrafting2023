package main.java.DesignPatterns.Adapter;

public class SocketObjectAdapterImpl implements SocketAdapter {

    Socket socket = new Socket();

    @Override
    public Volt get10Volts() {
        Volt voltage = socket.getStandardVoltage();
        return convertToBatteryVoltage(voltage, 22);
    }

    private Volt convertToBatteryVoltage(Volt voltage, int i) {
        return new Volt(voltage.getVolts() / i);
    }
}
