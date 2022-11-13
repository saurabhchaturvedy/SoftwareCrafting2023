package main.java.LowLevelDesign.TicTacToe2;

import java.util.ArrayList;
import java.util.List;

public class Player {

    Piece piece;

    List<Cell> moves = new ArrayList<>();

    public Player(Piece piece) {
        this.piece = piece;
    }

    public void addMove(Cell cell) {
        this.moves.add(cell);
    }

    public List<Cell> getMoves() {
        return this.moves;
    }
}
