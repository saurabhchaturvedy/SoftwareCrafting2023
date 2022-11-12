package main.java.DesignPatterns.Behavioural.Strategy;

public class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(Shopper shopper) {
        this.strategy.pay(shopper);
    }
}