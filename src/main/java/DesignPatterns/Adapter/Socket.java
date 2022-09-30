package main.java.DesignPatterns.Adapter;

public class Socket {

    public Volt getVoltage() {
        return new Volt(220);
    }
}
