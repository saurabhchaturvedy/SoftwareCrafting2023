package main.java.DesignPatterns.Structural.Adapter;

public class Socket {

    public Volt getStandardVoltage() {
        return new Volt(220);
    }
}
