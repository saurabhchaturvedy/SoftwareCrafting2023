package main.java.DesignPatterns.Structural.Proxy;

public class Main {

    public static void main(String[] args) {
        ProxyWebServer proxy = new ProxyWebServer();

        proxy.makeRequest("http://www.google.com");

        proxy.blockWebsite("http://www.facebook.com");

        proxy.makeRequest("http://www.facebook.com");
    }
}
