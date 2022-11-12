package main.java.DesignPatterns.Structural.Proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyWebServer implements WebServer {

    RealWebServer realWebServer;
    List<String> blockedSites = new ArrayList<>();

    ProxyWebServer() {
        this.realWebServer = new RealWebServer();
    }

    public void blockWebsite(String url) {
        this.blockedSites.add(url);
    }

    @Override
    public void makeRequest(String url) {

        if (!blockedSites.contains(url)) {
            this.realWebServer.makeRequest(url);
        } else {
            System.out.println("This website is blocked !! Contact your administrator .");
        }
    }
}
