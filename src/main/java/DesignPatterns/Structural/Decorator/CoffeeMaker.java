package main.java.DesignPatterns.Structural.Decorator;

public class CoffeeMaker {

    public static Coffee makeCoffee(CoffeePack pack) {
        Coffee coffee = new SimpleCoffee();

        for (int i = 0; i < pack.getMilk(); i++) {
            coffee = new WithMilk(coffee);
        }

        for (int i = 0; i < pack.getSugar(); i++) {
            coffee = new WithSugar(coffee);
        }

        return coffee;
    }

    public static void main(String[] args) {
        CoffeePack coffeePack = new CoffeePack(2, 3);
        Coffee coffee = makeCoffee(coffeePack);
        System.out.println(coffee.getCost());
        System.out.println(coffee.getIngredients());
    }
}