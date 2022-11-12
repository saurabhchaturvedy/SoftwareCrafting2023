package main.java.LowLevelDesign.CoffeeMachine.beverages;

import java.util.logging.Logger;

import static main.java.LowLevelDesign.CoffeeMachine.constants.BeverageConstants.BEVERAGE_GREEN_TEA;

public class GreenTea implements IBeverage {

    private Logger logger = Logger.getLogger("GreenTea");

    @Override
    public String getType() {
        return BEVERAGE_GREEN_TEA;
    }

    @Override
    public void drink() {
        System.out.println("I am drinking : " + BEVERAGE_GREEN_TEA);
    }

}