package main.java.DesignPatterns.Structural.Decorator;

public class CoffeePack {

    int milk;
    int sugar;

    public CoffeePack(int milk, int sugar) {
        this.milk = milk;
        this.sugar = sugar;
    }

    public int getMilk() {
        return milk;
    }

    public int getSugar() {
        return sugar;
    }
}
