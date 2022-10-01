package main.java.DesignPatterns.Structural.Decorator;

public class WithMilk extends CoffeeDecorator {
    WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ",Milk";
    }
}
