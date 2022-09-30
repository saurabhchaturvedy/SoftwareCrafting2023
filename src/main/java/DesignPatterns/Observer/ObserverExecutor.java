package main.java.DesignPatterns.Observer;

import java.util.Scanner;

public class ObserverExecutor {

    public static void main(String[] args) {
        CricketScore cricketScore = new CricketScore();

        new Subscriber1(cricketScore);
        new Subscriber2(cricketScore);
        new Subscriber3(cricketScore);

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setRuns(0);
        scoreBoard.setWickets(0);
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
