package main.java.LowLevelDesign.CoffeeMachine.beverages;

import java.util.logging.Logger;

import static main.java.LowLevelDesign.CoffeeMachine.constants.BeverageConstants.BEVERAGE_HOT_COFFEE;

public class HotCoffee implements IBeverage {
    private Logger logger = Logger.getLogger("HotCoffee");

    @Override
    public String getType() {
        return BEVERAGE_HOT_COFFEE;
    }


    @Override
    public void drink() {
        System.out.println("I am drinking : " + BEVERAGE_HOT_COFFEE);
    }
}