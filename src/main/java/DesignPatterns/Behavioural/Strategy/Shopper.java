package main.java.DesignPatterns.Behavioural.Strategy;

public class Shopper {

    private String name;
    private CardDetails cardDetails;
    private ShoppingCart shoppingCart;

    //suitable constructor , getters and setters

    public void addItemToCart(Item item) {
        this.shoppingCart.add(item);
    }

    public void payUsingCOD() {
        PaymentContext pymtContext = new PaymentContext(new CashOnDeliveryStrategy());
        pymtContext.makePayment(this);
    }

    public void payUsingCard() {
        PaymentContext pymtContext = new PaymentContext(new CardPaymentStrategy());
        pymtContext.makePayment(this);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public String getName() {
        return name;
    }
}