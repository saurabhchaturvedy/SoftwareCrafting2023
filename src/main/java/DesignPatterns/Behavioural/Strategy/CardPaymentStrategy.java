package main.java.DesignPatterns.Behavioural.Strategy;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Shopper shopper) {
        CardDetails cardDetails = shopper.getCardDetails();
        double amount = shopper.getShoppingCart().getTotal();
        completePayment(cardDetails, amount);
        System.out.println("Credit/Debit card Payment of Rs. " + amount + " made by " + shopper.getName());
    }

    private void completePayment(CardDetails cardDetails, double amount) {
    }
}