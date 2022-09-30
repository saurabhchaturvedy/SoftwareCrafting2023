package main.java.DesignPatterns.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class CricketScore {

    List<Observer> observers = new ArrayList<>();
    ScoreBoard scoreBoard;


    public String getScoreBoard() {
        return scoreBoard.getRuns() + "/" + scoreBoard.getWickets();
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
