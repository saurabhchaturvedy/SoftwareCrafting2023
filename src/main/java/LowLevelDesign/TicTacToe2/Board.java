package main.java.LowLevelDesign.TicTacToe2;

public class Board {


    Cell[][] cells;

    int row;

    int cols;

    Board(int rows, int cols) {
        this.row = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
    }

    void initializeBoard() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j, Piece.EMPTY);
            }
        }
    }

    void showBoardStatus() {

        System.out.println(" -----------------------------");
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getPiece() == Piece.EMPTY) {
                    System.out.print(" | " + "  " + " | ");
                } else {
                    System.out.print(" | " + cells[i][j].getPiece() + "  | ");
                }
            }
            System.out.println();
            System.out.println(" -----------------------------");
        }
    }
}
