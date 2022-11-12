package main.java.DesignPatterns.Behavioural.Strategy;

public class CashOnDeliveryStrategy implements PaymentStrategy {
    @Override
    public void pay(Shopper shopper) {
        double amount = shopper.getShoppingCart().getTotal();
        System.out.println(shopper.getName() + " selected Cash On Delivery for Rs." + amount );
    }
}