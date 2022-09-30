package main.java.DesignPatterns.Observer;

public class Subscriber1 extends Observer {

    Subscriber1(CricketScore cricketScore) {
        this.cricketScore = cricketScore;
        this.cricketScore.addObserver(this);
    }

    @Override
    public void update() {

        System.out.println(" Subscriber 1 notified : " + cricketScore.getScoreBoard());
    }
}
