package main.java.DesignPatterns.Structural.Decorator;

public class WithSugar extends CoffeeDecorator {
    WithSugar(Coffee coffee) {
        super(coffee);
    }


    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ",Sugar";
    }
}
