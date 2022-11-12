package main.java.LowLevelDesign.CoffeeMachine.beverages;



import java.util.logging.Logger;

import static main.java.LowLevelDesign.CoffeeMachine.constants.BeverageConstants.BEVERAGE_HOT_TEA;

public class HotTea implements IBeverage {
    private Logger logger = Logger.getLogger("HotTea");

    @Override
    public String getType() {
        return BEVERAGE_HOT_TEA;
    }

    @Override
    public void drink() {
        System.out.println("I am drinking : " + BEVERAGE_HOT_TEA);
    }
}