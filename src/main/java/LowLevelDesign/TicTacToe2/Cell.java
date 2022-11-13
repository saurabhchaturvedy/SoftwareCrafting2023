package main.java.LowLevelDesign.TicTacToe2;

public class Cell {

    int row;
    int col;
    Piece piece;

    Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
