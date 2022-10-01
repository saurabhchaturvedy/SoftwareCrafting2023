package main.java.LowLevelDesign.NokiaSnakeGame;

public class Board {

    int ROW_COUNT;
    int COL_COUNT;

    Cell[][] cells;

    Board(int rows, int cols) {
        ROW_COUNT = rows;
        COL_COUNT = cols;
        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generateFood() {
        System.out.println("*** Going to generate food ***");
        int row = (int) (Math.random() * ROW_COUNT);
        int col = (int) (Math.random() * COL_COUNT);

        cells[row][col].setType(CellType.FOOD);
        System.out.println("Food is generated at : " + row + " : " + col);
    }
}
