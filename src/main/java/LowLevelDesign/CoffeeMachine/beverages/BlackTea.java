package main.java.LowLevelDesign.CoffeeMachine.beverages;

import java.util.logging.Logger;

import static main.java.LowLevelDesign.CoffeeMachine.constants.BeverageConstants.BEVERAGE_BLACK_TEA;

public class BlackTea implements IBeverage {

    private Logger logger = Logger.getLogger("BlackTea");

    @Override
    public String getType() {
        return BEVERAGE_BLACK_TEA;
    }

    @Override
    public void drink() {
        System.out.println("I am drinking : " + BEVERAGE_BLACK_TEA);
    }
}