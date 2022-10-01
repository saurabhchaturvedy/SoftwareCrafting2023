package main.java.DesignPatterns.Structural.Decorator;

public class CoffeeDecorator implements Coffee {

    Coffee decoratedCoffee;

    CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
}
