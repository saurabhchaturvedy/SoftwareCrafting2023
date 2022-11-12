package main.java.DesignPatterns.Behavioural.Strategy;

public class ShoppingCart {

    Item item;

    double total;

    public void add(Item item) {
        this.item = item;
    }

    public double getTotal() {
        return total;
    }
}
