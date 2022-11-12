package main.java.LowLevelDesign.CoffeeMachine.composers;

import java.util.Map;

import static main.java.LowLevelDesign.CoffeeMachine.constants.BeverageConstants.BEVERAGE_GREEN_TEA;

public class GreenTeaComposer implements IComposer {
    Map<String, Integer> ingredientsRulesForGreenTea;

    @Override
    public String getBeverageType() {
        return BEVERAGE_GREEN_TEA;
    }

    @Override
    public Map<String, Integer> getRulesForComposer() {
        return ingredientsRulesForGreenTea;
    }

    @Override
    public void setRulesForComposer(Map<String, Integer> ingredientsRulesForGreenTea) {
        this.ingredientsRulesForGreenTea = ingredientsRulesForGreenTea;
    }
}