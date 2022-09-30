package main.java.DesignPatterns.Behavioural.Observer;

public class Subscriber3 extends Observer {
    Subscriber3(CricketScore cricketScore) {
        this.cricketScore = cricketScore;
        this.cricketScore.addObserver(this);
    }

    @Override
    public void update() {

        System.out.println(" Subscriber 3 notified : " + cricketScore.getScoreBoard());
    }
}
