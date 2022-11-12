package main.java.DesignPatterns.Structural.Proxy;

public class RealWebServer implements WebServer {
    @Override
    public void makeRequest(String url) {
        System.out.println("request processed...for URL : " + url);
    }
}
