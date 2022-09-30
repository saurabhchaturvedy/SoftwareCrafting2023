package main.java.DesignPatterns.Observer;

public class Subscriber2 extends Observer {

    Subscriber2(CricketScore cricketScore) {
        this.cricketScore = cricketScore;
        this.cricketScore.addObserver(this);
    }

    @Override
    public void update() {

        System.out.println(" Subscriber 1 notified : " + cricketScore.getScoreBoard());
    }
}
