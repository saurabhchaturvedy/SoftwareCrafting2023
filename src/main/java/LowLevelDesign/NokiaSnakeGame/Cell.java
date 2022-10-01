package main.java.LowLevelDesign.NokiaSnakeGame;

public class Cell {

    int row;
    int col;
    CellType type;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellType getType() {
        return type;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setType(CellType type) {
        this.type = type;
    }
}
