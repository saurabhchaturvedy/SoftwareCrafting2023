package main.java.DesignPatterns.Adapter;

public class AdapterExecutor {

    public static void main(String[] args) {

        Plug plug = new Plug(new SocketAdapterImpl().get10Volts());
    }
}
