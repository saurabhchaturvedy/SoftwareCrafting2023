package main.java.DesignPatterns.Structural.Decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getIngredients() {
        return "Plain Coffee";
    }
}
