package main.java.LowLevelDesign.SnakesAndLadders;

import java.util.ArrayList;
import java.util.List;

public class SnakesAndLadders {

    Board board;
    List<Player> players;

    SnakesAndLadders() {
        board = new Board(100);
        players = new ArrayList<>();
    }

    void addPlayer(Player player) {
        this.players.add(player);
    }

    void play() {
        boolean isTargetCellReached = false;
        Dice dice = new Dice(6);

        while (!isTargetCellReached) {
            for (Player player : players) {

                int newPosition = dice.roll();
                System.out.println(player.name + " rolls dice with value : " + newPosition);
                isTargetCellReached = player.move(board, newPosition);
                if (isTargetCellReached) {
                    System.out.println(player.name + " has won the game !!");
                    break;
                }
            }
        }
    }
}
