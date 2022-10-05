package main.java.LowLevelDesign.TicTacToe;

public class Board {

    public Cell[][] cells;
    private final int size;

    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        initializeBoard();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void printBoardStatus() {
        System.out.println(" -----------------------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getPiece() == null) {
                    System.out.print(" | " + "  " + " | ");
                } else {
                    System.out.print(" | " + cells[i][j].getPiece() + "  | ");
                }
            }
            System.out.println();
            System.out.println(" -----------------------------");
        }
    }

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(i, j, null);
            }
        }
        System.out.println("GAME STARTED");
        printBoardStatus();
    }

}