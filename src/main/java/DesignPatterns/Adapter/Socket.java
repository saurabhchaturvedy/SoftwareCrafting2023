package main.java.DesignPatterns.Adapter;

public class Socket {

    public Volt getStandardVoltage() {
        return new Volt(220);
    }
}
