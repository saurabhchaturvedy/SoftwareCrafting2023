package main.java.DesignPatterns.Adapter;

public class Plug {

    final int VOLTAGE_LIMIT = 10;

    Plug(Volt v) {
        if (v.getVolts() == VOLTAGE_LIMIT) {
            // charging works
            System.out.println(" Standard voltage successfully converted to 10 Volts...charging !!");
        } else {
            // mobile gets burned
            System.out.println("Charger & mobile got burn't !!");
        }
    }
}
