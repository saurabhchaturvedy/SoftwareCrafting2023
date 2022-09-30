package main.java.DesignPatterns.Behavioural.Observer;

import java.util.Scanner;

public class ObserverExecutor {

    public static void main(String[] args) {
        CricketScore cricketScore = new CricketScore();

        Subscriber1 subscriber1 = new Subscriber1(cricketScore);
        Subscriber2 subscriber2 = new Subscriber2(cricketScore);
        Subscriber3 subscriber3 = new Subscriber3(cricketScore);

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setRuns(0);
        scoreBoard.setWickets(0);
        cricketScore.removeObserver(subscriber2);
        cricketScore.setScoreBoard(scoreBoard);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String score = scanner.nextLine();
            String[] scores = score.split(" ");
            scoreBoard.setRuns(Integer.parseInt(scores[0]));
            scoreBoard.setWickets(Integer.parseInt(scores[1]));

            cricketScore.setScoreBoard(scoreBoard);
        }
    }
}
