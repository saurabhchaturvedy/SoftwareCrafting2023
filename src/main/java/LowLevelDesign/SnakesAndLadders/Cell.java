package main.java.LowLevelDesign.SnakesAndLadders;

public class Cell {

    int start;
    int end;
    CellType type;

    Cell(int start, int end, CellType type) {
        this.start = start;
        this.end = end;
        this.type = type;
    }
}
